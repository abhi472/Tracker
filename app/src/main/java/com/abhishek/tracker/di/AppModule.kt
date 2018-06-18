package com.abhishek.tracker.di

import dagger.Module

@Module(includes = [DatabaseModule::class, RepositoryModule::class])
class AppModule {
}