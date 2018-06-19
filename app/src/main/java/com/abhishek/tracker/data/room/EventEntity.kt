package com.abhishek.tracker.data.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "event")
data class EventEntity constructor(
        @PrimaryKey
        @ColumnInfo(name = "_id")
        val eventId: Int,

        val eventName: String,

        val time: Long
)