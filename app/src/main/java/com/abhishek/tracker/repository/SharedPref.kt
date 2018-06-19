package com.abhishek.tracker.repository

interface SharedPref {

    fun getLastCount(): Int

    fun setLastCount(count: Int)
}