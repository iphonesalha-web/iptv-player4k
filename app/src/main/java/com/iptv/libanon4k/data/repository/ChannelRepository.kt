package com.iptv.libanon4k.data.repository

import com.iptv.libanon4k.data.local.dao.ChannelDao
import com.iptv.libanon4k.data.local.dao.RecentlyWatchedDao
import com.iptv.libanon4k.data.model.Channel
import com.iptv.libanon4k.data.model.RecentlyWatched
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChannelRepository @Inject constructor(
    private val channelDao: ChannelDao,
    private val recentlyWatchedDao: RecentlyWatchedDao
) {

    fun getChannelsByCategory(accountId: Long, categoryId: String): Flow<List<Channel>> =
        channelDao.getChannelsByCategory(accountId, categoryId)

    fun getChannelsByAccount(accountId: Long): Flow<List<Channel>> =
        channelDao.getChannelsByAccount(accountId)

    fun getFavoriteChannels(accountId: Long): Flow<List<Channel>> =
        channelDao.getFavoriteChannels(accountId)

    fun searchChannels(accountId: Long, query: String): Flow<List<Channel>> =
        channelDao.searchChannels(accountId, "%$query%")

    suspend fun insertChannels(channels: List<Channel>) {
        channelDao.insertChannels(channels)
    }

    suspend fun getChannelById(id: String): Channel? = channelDao.getChannelById(id)

    suspend fun addToFavorites(id: String) {
        channelDao.addToFavorites(id)
    }

    suspend fun removeFromFavorites(id: String) {
        channelDao.removeFromFavorites(id)
    }

    suspend fun recordWatchHistory(channel: Channel) {
        val recentlyWatched = RecentlyWatched(
            id = channel.id,
            accountId = 0,
            contentId = channel.id,
            contentType = "channel",
            title = channel.name,
            poster = channel.logo,
            lastWatchedTime = System.currentTimeMillis(),
            duration = 0,
            watchedProgress = 0
        )
        recentlyWatchedDao.insertRecentlyWatched(recentlyWatched)
    }

    suspend fun updateWatchedTime(channelId: String, duration: Long, position: Long) {
        channelDao.updateLastWatched(channelId, System.currentTimeMillis(), duration)
    }
}
