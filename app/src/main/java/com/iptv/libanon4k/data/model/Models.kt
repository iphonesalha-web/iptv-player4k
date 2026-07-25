package com.iptv.libanon4k.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val serverUrl: String,
    val username: String,
    val password: String,
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis(),
    val lastSync: Long = 0
)

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    val id: String,
    val accountId: Long,
    val name: String,
    val type: String, // "live", "movie", "series"
    val icon: String = ""
)

@Entity(tableName = "channels")
data class Channel(
    @PrimaryKey
    val id: String,
    val accountId: Long,
    val categoryId: String,
    val name: String,
    val logo: String = "",
    val streamUrl: String,
    val epgChannelId: String = "",
    val number: Int = 0,
    val isFavorite: Boolean = false,
    val lastWatchedTime: Long = 0,
    val lastWatchedDuration: Long = 0
)

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey
    val id: String,
    val accountId: Long,
    val categoryId: String,
    val title: String,
    val poster: String = "",
    val backdrop: String = "",
    val description: String = "",
    val duration: Long = 0,
    val streamUrl: String,
    val isFavorite: Boolean = false,
    val watchedProgress: Long = 0,
    val lastWatchedTime: Long = 0
)

@Entity(tableName = "series")
data class Series(
    @PrimaryKey
    val id: String,
    val accountId: Long,
    val categoryId: String,
    val title: String,
    val poster: String = "",
    val backdrop: String = "",
    val description: String = "",
    val isFavorite: Boolean = false,
    val lastWatchedTime: Long = 0
)

@Entity(tableName = "episodes")
data class Episode(
    @PrimaryKey
    val id: String,
    val seriesId: String,
    val seasonNumber: Int,
    val episodeNumber: Int,
    val title: String,
    val description: String = "",
    val thumbnail: String = "",
    val duration: Long = 0,
    val streamUrl: String,
    val watchedProgress: Long = 0,
    val lastWatchedTime: Long = 0
)

@Entity(tableName = "epg_programs")
data class EpgProgram(
    @PrimaryKey
    val id: String,
    val channelId: String,
    val title: String,
    val description: String = "",
    val startTime: Long,
    val endTime: Long,
    val icon: String = ""
)

@Entity(tableName = "recently_watched")
data class RecentlyWatched(
    @PrimaryKey
    val id: String,
    val accountId: Long,
    val contentId: String,
    val contentType: String, // "channel", "movie", "episode"
    val title: String,
    val poster: String = "",
    val lastWatchedTime: Long = System.currentTimeMillis(),
    val duration: Long = 0,
    val watchedProgress: Long = 0
)
