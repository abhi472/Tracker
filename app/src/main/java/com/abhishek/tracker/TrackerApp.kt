package com.abhishek.tracker

import android.content.Context
import com.abhishek.tracker.di.DaggerAppComponent
import com.abhishek.tracker.di.DatabaseModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class TrackerApp: DaggerApplication() {

    lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    override fun attachBaseContext(base: Context?) {
        androidInjector =DaggerAppComponent
                .builder()
                .application(this)
                .database(DatabaseModule())
                .build()
    }
}