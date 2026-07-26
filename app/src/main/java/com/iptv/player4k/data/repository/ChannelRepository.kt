package com.iptv.player4k.data.repository

import com.iptv.player4k.data.local.entity.ChannelEntity
import kotlinx.coroutines.flow.Flow

interface ChannelRepository {
    fun observeChannels(): Flow<List<ChannelEntity>>
    fun observeFavorites(): Flow<List<ChannelEntity>>
    suspend fun importPlaylist(playlistName: String, playlistUrl: String): Result<Unit>
    suspend fun setFavorite(channelId: Long, isFavorite: Boolean)
}
