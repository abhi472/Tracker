package com.abhishek.tracker.repository

import android.arch.lifecycle.LiveData
import com.abhishek.tracker.data.room.EventDao
import com.abhishek.tracker.data.room.EventEntity
import com.abhishek.tracker.data.room.TrackerDatabase
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepository @Inject constructor(private val database: TrackerDatabase, private val dao: EventDao): Event{
    override fun save(event: EventEntity): Completable  =
            Completable.create({
                database.runInTransaction { dao.save(event) }
                it.onComplete()
            })

    override fun get(): LiveData<List<EventEntity>> = dao.get()

}