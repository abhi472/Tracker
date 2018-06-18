package com.abhishek.tracker.data

import android.arch.persistence.room.Database
import com.abhishek.tracker.BuildConfig

@Database(entities = [EventEntity::class],
        version = BuildConfig.DB_SCHEMA_VERSION,
        exportSchema = false)
abstract class TrackerDatabase {
    abstract val eventDao: EventDao
}