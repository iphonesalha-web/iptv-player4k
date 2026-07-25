package com.iptv.player4k.data.repository

import com.iptv.player4k.data.models.Playlist

interface PlaylistRepository {
    suspend fun getAllPlaylists(): List<Playlist>
    suspend fun getPlaylistById(id: Long): Playlist?
    suspend fun insertPlaylist(playlist: Playlist)
    suspend fun deletePlaylist(id: Long)
    suspend fun updatePlaylist(playlist: Playlist)
}
