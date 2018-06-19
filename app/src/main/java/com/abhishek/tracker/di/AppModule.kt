package com.abhishek.tracker.di

import android.content.Context
import com.abhishek.tracker.TrackerApp
import dagger.Module
import dagger.Provides

@Module(includes = [DatabaseModule::class, RepositoryModule::class, ViewModelModule::class])
internal class AppModule {
    @Provides
    internal fun provideContext(application: TrackerApp): Context {
        return application
    }
}