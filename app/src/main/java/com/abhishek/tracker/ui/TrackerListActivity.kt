package com.abhishek.tracker.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.abhishek.tracker.R
import com.abhishek.tracker.databinding.ActivityTrackerListBinding
import com.abhishek.tracker.service.TrackerService
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class TrackerListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    val trackerListViewModel: TrackerListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(TrackerListViewModel::class.java)
    }

    val binding: ActivityTrackerListBinding by lazy {
        DataBindingUtil.setContentView<ActivityTrackerListBinding>(this, R.layout.activity_tracker_list)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, TrackerService::class.java)
        startService(intent)
    }


}
