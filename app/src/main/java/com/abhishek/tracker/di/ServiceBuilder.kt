package com.abhishek.tracker.di

import com.abhishek.tracker.service.TrackerService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ServiceBuilder {

    @ContributesAndroidInjector()
    internal abstract fun contributeTrackerService(): TrackerService
}