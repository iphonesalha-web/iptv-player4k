package com.iptv.player4k.data.repository

import com.iptv.player4k.data.local.entity.PlaylistEntity
import kotlinx.coroutines.flow.Flow

interface PlaylistRepository {
    fun observePlaylists(): Flow<List<PlaylistEntity>>
    suspend fun insertPlaylist(name: String, url: String): Long
    suspend fun deletePlaylist(id: Long)
}
