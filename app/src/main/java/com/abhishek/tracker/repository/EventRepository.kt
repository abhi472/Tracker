package com.abhishek.tracker.repository

import android.arch.lifecycle.LiveData
import com.abhishek.tracker.data.EventDao
import com.abhishek.tracker.data.EventEntity
import com.abhishek.tracker.data.TrackerDatabase
import io.reactivex.Completable
import io.reactivex.Single
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