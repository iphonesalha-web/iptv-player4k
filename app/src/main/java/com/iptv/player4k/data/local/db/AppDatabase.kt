package com.iptv.player4k.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iptv.player4k.data.local.dao.ChannelDao
import com.iptv.player4k.data.local.dao.PlaylistDao
import com.iptv.player4k.data.local.entity.ChannelEntity
import com.iptv.player4k.data.local.entity.PlaylistEntity

@Database(
    entities = [PlaylistEntity::class, ChannelEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playlistDao(): PlaylistDao
    abstract fun channelDao(): ChannelDao
}
