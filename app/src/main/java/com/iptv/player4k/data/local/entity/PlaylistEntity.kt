package com.iptv.player4k.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val url: String,
    val createdAt: Long = System.currentTimeMillis(),
    val isActive: Boolean = true
)
