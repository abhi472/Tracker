package com.abhishek.tracker.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(event: EventEntity): Long

    @Query("SELECT * FROM event")
    fun get(): LiveData<List<EventEntity>>
}