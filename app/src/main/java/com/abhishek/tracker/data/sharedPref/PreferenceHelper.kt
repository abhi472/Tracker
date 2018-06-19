package com.abhishek.tracker.data.sharedPref

interface PreferenceHelper {

    fun getLastCount(): Int

    fun setLastCount(count: Int)
}