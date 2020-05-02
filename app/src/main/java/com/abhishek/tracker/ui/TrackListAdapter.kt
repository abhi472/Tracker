package com.abhishek.tracker.ui

import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.abhishek.tracker.R
import com.abhishek.tracker.data.room.EventEntity
import com.abhishek.tracker.databinding.EventCardBinding
import javax.inject.Inject

class TrackListAdapter @Inject constructor(var context: Context) : RecyclerView.Adapter<TrackListAdapter.ViewHolder>(){

    var list: List<EventEntity>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: EventCardBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.event_card, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?:0
    }

    fun setItem(list:List<EventEntity>?) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val vm = TrackListAdapterViewModel()
        vm.setVal(list?.get(position), position)
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
