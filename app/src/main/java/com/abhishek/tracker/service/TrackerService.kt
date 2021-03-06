package com.abhishek.tracker.service

import android.content.Intent
import android.os.IBinder
import android.app.KeyguardManager
import android.content.Context
import android.content.BroadcastReceiver
import android.content.IntentFilter
import com.abhishek.tracker.data.room.EventEntity
import com.abhishek.tracker.repository.Event
import com.abhishek.tracker.repository.SharedPref
import dagger.android.DaggerService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


class TrackerService : DaggerService() {

    @Inject
    lateinit var eventRepository: Event

    @Inject
    lateinit var sharedPrefRepository: SharedPref

    val disposable = CompositeDisposable()


    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onCreate() {

        super.onCreate()
        registerBroadcastReceiver()
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

    private fun registerBroadcastReceiver() {

        val theFilter = IntentFilter()
        /** System Defined Broadcast  */
        theFilter.addAction(Intent.ACTION_SCREEN_ON)
        theFilter.addAction(Intent.ACTION_SCREEN_OFF)
        theFilter.addAction(Intent.ACTION_USER_PRESENT)

        val screenOnOffReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val strAction = intent.action
                var count: Int = sharedPrefRepository.getLastCount()
                var eventEntity: EventEntity? = null

                val myKM = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
                if (strAction == Intent.ACTION_USER_PRESENT
                        || strAction == Intent.ACTION_SCREEN_OFF) {
                    eventEntity = if (myKM.inKeyguardRestrictedInputMode()) {
                        EventEntity(count, "Locked and Screen off", Date().time)

                        //locked & off
                    } else {
                        EventEntity(count, "Unlocked and Screen off", Date().time)
                    }
                }
                if (strAction == Intent.ACTION_USER_PRESENT
                        || strAction == Intent.ACTION_SCREEN_ON) {
                    eventEntity = if (myKM.inKeyguardRestrictedInputMode()) {
                        EventEntity(count, "Locked and Screen on", Date().time)
                    } else {
                        EventEntity(count, "Unlocked and Screen on", Date().time)
                    }
                }

                disposable.add(eventRepository
                        .save(eventEntity!!)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            sharedPrefRepository.setLastCount(++count)
                        }, {

                        }))

            }
        }


        applicationContext.registerReceiver(screenOnOffReceiver, theFilter)
    }


}
