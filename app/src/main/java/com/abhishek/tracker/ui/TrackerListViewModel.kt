package com.abhishek.tracker.ui

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.abhishek.tracker.R
import com.abhishek.tracker.repository.Event
import javax.inject.Inject

class TrackerListViewModel @Inject constructor(eventRepository: Event): ViewModel(),
        LifecycleObserver {

    val genericPair: Pair<Int, Int> = Pair(R.string.generic_error, R.drawable.ic_error_generic)
    val emptyListPair: Pair<Int, Int> = Pair(R.string.empty, R.drawable.ic_empty_calendar)

    var progressVisibility: ObservableBoolean? = ObservableBoolean(true)
    var errorVisibility: ObservableBoolean? = ObservableBoolean(false)
    var errorAssets: ObservableField<Pair<Int, Int>> = ObservableField(emptyListPair)
    val listVisibility: ObservableBoolean = ObservableBoolean(false)

}