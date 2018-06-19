package com.abhishek.tracker.service

import android.content.Intent
import android.os.IBinder
import android.app.KeyguardManager
import android.content.Context
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.util.Log
import com.abhishek.tracker.data.EventEntity
import com.abhishek.tracker.repository.Event
import dagger.android.DaggerService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


class TrackerService : DaggerService() {

    @Inject
    lateinit var eventRepository: Event

    val disposable = CompositeDisposable()


    var count: Int = 1

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

                val myKM = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
                if (strAction == Intent.ACTION_USER_PRESENT || strAction == Intent.ACTION_SCREEN_OFF || strAction == Intent.ACTION_SCREEN_ON)
                    if (myKM.inKeyguardRestrictedInputMode()) {
                        val eventEntity = EventEntity(count, "Locked", Date().time)
                        disposable.add(eventRepository
                                .save(eventEntity)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({
                                   Log.d("check", "success")
                                    count++
                                },{
                                    Log.d("check", "fail")

                                }))
                    } else {
                        println("Screen off " + "UNLOCKED")
                    }

            }
        }

        applicationContext.registerReceiver(screenOnOffReceiver, theFilter)
    }


}
