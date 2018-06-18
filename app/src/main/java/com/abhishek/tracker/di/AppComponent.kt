package com.abhishek.tracker.di

import com.abhishek.tracker.TrackerApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBuilder::class,
            ServiceBuilder::class,
            AppModule::class
        ])
interface AppComponent : AndroidInjector<TrackerApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TrackerApp): Builder

        fun database(database: DatabaseModule): Builder


        fun build(): AppComponent
    }

    override fun inject(instance: TrackerApp)
}