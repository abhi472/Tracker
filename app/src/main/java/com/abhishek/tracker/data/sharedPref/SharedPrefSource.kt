package com.abhishek.tracker.data.sharedPref

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefSource @Inject constructor(val context: Context) : PreferenceHelper {


    private var mPrefs: SharedPreferences = context.getSharedPreferences("tracker", Context.MODE_PRIVATE)

    private val prefKeyCount = "prefKeyCount"



    override fun getLastCount(): Int {
        return mPrefs.getInt(prefKeyCount, 1)


    }

    override fun setLastCount(count: Int) {
        mPrefs.edit().putInt(prefKeyCount, count).apply()

    }

}