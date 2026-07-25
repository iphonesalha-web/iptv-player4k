package com.iptv.player4k.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class Channel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val playlistId: Long,
    val name: String,
    val logo: String = "",
    val url: String,
    val group: String = "",
    val epg: String = "",
    val isFavorite: Boolean = false,
    val duration: Long = 0,
    val lastWatched: Long = 0
)
