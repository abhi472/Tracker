package com.abhishek.tracker.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class EventEntity constructor(
        @PrimaryKey
        @ColumnInfo(name = "_id")
        val eventId: Int,

        val eventName: String,

        val time: Long
)