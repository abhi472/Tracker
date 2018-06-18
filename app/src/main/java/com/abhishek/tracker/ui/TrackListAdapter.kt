package com.abhishek.tracker.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.abhishek.tracker.R
import com.abhishek.tracker.databinding.EventCardBinding
import com.abhishek.tracker.repository.Event
import javax.inject.Inject

class TrackListAdapter @Inject constructor(var context: Context) : RecyclerView.Adapter<TrackListAdapter.ViewHolder>(){

    var list: ArrayList<Event>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: EventCardBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.event_card, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?:0
    }

    fun setItem(list:ArrayList<Event>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val vm = TrackListAdapterViewModel()
        vm.setVal(list?.get(position))
        holder.setViewModel(vm)

    }


    class ViewHolder(val binding: EventCardBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun setViewModel(trackListAdapterViewModel: TrackListAdapterViewModel) {
            binding.viewModel = trackListAdapterViewModel
            binding.executePendingBindings()

        }
    }
}