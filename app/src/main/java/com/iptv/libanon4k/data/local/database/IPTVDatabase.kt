package com.iptv.libanon4k.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iptv.libanon4k.data.local.dao.AccountDao
import com.iptv.libanon4k.data.local.dao.CategoryDao
import com.iptv.libanon4k.data.local.dao.ChannelDao
import com.iptv.libanon4k.data.local.dao.EpisodeDao
import com.iptv.libanon4k.data.local.dao.EpgDao
import com.iptv.libanon4k.data.local.dao.MovieDao
import com.iptv.libanon4k.data.local.dao.RecentlyWatchedDao
import com.iptv.libanon4k.data.local.dao.SeriesDao
import com.iptv.libanon4k.data.model.Account
import com.iptv.libanon4k.data.model.Category
import com.iptv.libanon4k.data.model.Channel
import com.iptv.libanon4k.data.model.Episode
import com.iptv.libanon4k.data.model.EpgProgram
import com.iptv.libanon4k.data.model.Movie
import com.iptv.libanon4k.data.model.RecentlyWatched
import com.iptv.libanon4k.data.model.Series

@Database(
    entities = [
        Account::class,
        Category::class,
        Channel::class,
        Movie::class,
        Series::class,
        Episode::class,
        EpgProgram::class,
        RecentlyWatched::class
    ],
    version = 1,
    exportSchema = false
)
abstract class IPTVDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun categoryDao(): CategoryDao
    abstract fun channelDao(): ChannelDao
    abstract fun movieDao(): MovieDao
    abstract fun seriesDao(): SeriesDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun epgDao(): EpgDao
    abstract fun recentlyWatchedDao(): RecentlyWatchedDao
}
