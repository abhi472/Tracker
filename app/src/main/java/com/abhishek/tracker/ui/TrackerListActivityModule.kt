package com.abhishek.tracker.ui

import dagger.Module
import dagger.Provides

@Module
class TrackerListActivityModule {

    @Provides
    fun provideInviteAdapter(context: TrackerListActivity): TrackListAdapter
            = TrackListAdapter(context)

}