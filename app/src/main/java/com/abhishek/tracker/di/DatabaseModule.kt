package com.abhishek.tracker.di

import androidx.room.Room
import com.abhishek.tracker.TrackerApp
import com.abhishek.tracker.data.room.EventDao
import com.abhishek.tracker.data.room.TrackerDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideTrackerDatabase(app: TrackerApp): TrackerDatabase {
        return Room.databaseBuilder(app, TrackerDatabase::class.java, "tracker.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideEventDao(db: TrackerDatabase): EventDao = db.eventDao
}