package com.abhishek.tracker.repository

import javax.inject.Inject
import javax.inject.Singleton
import com.abhishek.tracker.data.sharedPref.SharedPrefSource

@Singleton
class SharedPrefRepository @Inject constructor(private val sharedPrefSource: SharedPrefSource) : SharedPref {

    override fun getLastCount(): Int =
            sharedPrefSource.getLastCount()

    override fun setLastCount(count: Int) {
        sharedPrefSource.setLastCount(count)
    }

}