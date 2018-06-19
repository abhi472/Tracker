package com.abhishek.tracker.repository

import android.arch.lifecycle.LiveData
import com.abhishek.tracker.data.EventEntity
import io.reactivex.Completable
import io.reactivex.Single

interface Event {
    fun save(event: EventEntity): Completable

    fun get(): LiveData<List<EventEntity>>
}