package com.abhishek.tracker.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(event: EventEntity): Long

    @Query("SELECT * FROM event ORDER BY time DESC")
    fun get(): LiveData<List<EventEntity>>
}