package com.abhishek.tracker.di

import com.abhishek.tracker.TrackerListActivity
import com.abhishek.tracker.TrackerListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [TrackerListActivityModule::class])
    internal abstract fun contributeTrackerListInjector(): TrackerListActivity
}