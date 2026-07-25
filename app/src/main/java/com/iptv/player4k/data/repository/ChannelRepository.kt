package com.iptv.player4k.data.repository

import com.iptv.player4k.data.models.Channel

interface ChannelRepository {
    suspend fun getAllChannels(): List<Channel>
    suspend fun getChannelsByGroup(group: String): List<Channel>
    suspend fun getChannelsByPlaylist(playlistId: Long): List<Channel>
    suspend fun getChannelById(id: Long): Channel?
    suspend fun insertChannel(channel: Channel)
    suspend fun deleteChannel(id: Long)
    suspend fun updateChannel(channel: Channel)
    suspend fun addChannelToFavorites(channelId: Long)
    suspend fun removeChannelFromFavorites(channelId: Long)
}
