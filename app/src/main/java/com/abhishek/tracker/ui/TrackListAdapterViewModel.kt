package com.abhishek.tracker.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.abhishek.tracker.data.EventEntity
import com.abhishek.tracker.repository.Event
import java.util.*
import javax.inject.Inject

class TrackListAdapterViewModel @Inject constructor() : ViewModel() {

    val eventName: ObservableField<String> = ObservableField()
    val eventTime: ObservableField<String> = ObservableField()


    fun setVal(get: EventEntity?) {
        eventName.set(java.lang.String.format(Locale.getDefault(),
                "%s  %s",
                get?.eventId, get?.eventName ))
        eventTime.set(get?.time.toString())
    }
}