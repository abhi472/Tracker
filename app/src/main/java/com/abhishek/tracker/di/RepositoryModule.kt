package com.abhishek.tracker.di

import com.abhishek.tracker.repository.Event
import com.abhishek.tracker.repository.EventRepository
import com.abhishek.tracker.repository.SharedPref
import com.abhishek.tracker.repository.SharedPrefRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindEventRepositry(repository: EventRepository): Event

    @Binds
    fun bindSharedPrefRepository(repository: SharedPrefRepository): SharedPref

}