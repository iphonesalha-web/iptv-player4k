package com.iptv.player4k.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class ChannelEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val playlistId: Long,
    val name: String,
    val streamUrl: String,
    val logo: String = "",
    val groupName: String = "",
    val tvgId: String = "",
    val isFavorite: Boolean = false,
    val lastWatchedAt: Long = 0L
)
