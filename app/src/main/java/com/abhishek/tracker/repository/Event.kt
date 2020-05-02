package com.abhishek.tracker.repository

import androidx.lifecycle.LiveData
import com.abhishek.tracker.data.room.EventEntity
import io.reactivex.Completable

interface Event {
    fun save(event: EventEntity): Completable

    fun get(): LiveData<List<EventEntity>>
}