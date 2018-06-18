package com.abhishek.tracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class TrackerListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker_list)
        val intent = Intent(this, TrackerService::class.java)
        startService(intent)
    }
}
