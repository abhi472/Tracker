package com.abhishek.tracker.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abhishek.tracker.ui.TrackListAdapterViewModel
import com.abhishek.tracker.ui.TrackerListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TrackerListViewModel::class)
    fun bindTrackerListViewModel(viewModel: TrackerListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrackListAdapterViewModel::class)
    fun bindTrackListAdapterViewModel(viewModel: TrackListAdapterViewModel): ViewModel



}