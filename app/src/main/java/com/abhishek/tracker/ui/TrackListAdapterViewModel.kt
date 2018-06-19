package com.abhishek.tracker.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.abhishek.tracker.data.room.EventEntity
import java.util.*
import javax.inject.Inject
import java.text.SimpleDateFormat


class TrackListAdapterViewModel @Inject constructor() : ViewModel() {

    val eventName: ObservableField<String> = ObservableField()
    val eventTime: ObservableField<String> = ObservableField()


    fun setVal(get: EventEntity?, position: Int) {
        eventName.set(java.lang.String.format(Locale.getDefault(),
                "%s  %s",
                (position+1).toString(), get?.eventName ))
        eventTime.set(getDate(get?.time!!))
    }

    private fun getDate(milliSeconds: Long): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }
}