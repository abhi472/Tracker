package com.abhishek.tracker.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abhishek.tracker.BuildConfig

@Database(entities = [EventEntity::class],
        version = BuildConfig.DB_SCHEMA_VERSION,
        exportSchema = false)
abstract class TrackerDatabase: RoomDatabase() {
    abstract val eventDao: EventDao
}