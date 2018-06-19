package com.abhishek.tracker.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.abhishek.tracker.R
import com.abhishek.tracker.databinding.ActivityTrackerListBinding
import com.abhishek.tracker.service.TrackerService
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.util.Log


class TrackerListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: TrackListAdapter


    private val trackerListViewModel: TrackerListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(TrackerListViewModel::class.java)
    }

    private val binding: ActivityTrackerListBinding by lazy {
        DataBindingUtil.setContentView<ActivityTrackerListBinding>(this, R.layout.activity_tracker_list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!isMyServiceRunning(TrackerService::class.java)) {
        val intent = Intent(this, TrackerService::class.java)
        startService(intent)
            println("service is off")

        } else {
            println("service is on")
        }
        setup()
    }

    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                Log.i("isMyServiceRunning?", true.toString() + "")
                return true
            }
        }
        Log.i("isMyServiceRunning?", false.toString() + "")
        return false
    }

    private fun setup() {

        binding.let {
            it.viewModel = trackerListViewModel
            it.setLifecycleOwner(this)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        trackerListViewModel.liveData.observe(this, Observer {
            adapter.setItem(it)
            trackerListViewModel.updateVisibility()
        })
    }


}
