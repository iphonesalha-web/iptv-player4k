package com.iptv.player4k.data.repository

import com.iptv.player4k.data.local.dao.ChannelDao
import com.iptv.player4k.data.local.dao.PlaylistDao
import com.iptv.player4k.data.local.entity.ChannelEntity
import com.iptv.player4k.data.local.entity.PlaylistEntity
import com.iptv.player4k.data.remote.m3u.M3uRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val channelDao: ChannelDao,
    private val playlistDao: PlaylistDao,
    private val remoteDataSource: M3uRemoteDataSource
) : ChannelRepository {

    override fun observeChannels(): Flow<List<ChannelEntity>> =
        channelDao.observeAll()

    override fun observeFavorites(): Flow<List<ChannelEntity>> =
        channelDao.observeFavorites()

    override suspend fun importPlaylist(
        playlistName: String,
        playlistUrl: String
    ): Result<Unit> {
        return runCatching {
            val playlistId = playlistDao.insert(
                PlaylistEntity(
                    name = playlistName,
                    url = playlistUrl
                )
            )

            val channels = remoteDataSource.fetchChannels(playlistUrl)
                .map {
                    ChannelEntity(
                        playlistId = playlistId,
                        name = it.name,
                        streamUrl = it.url,
                        logo = it.logo,
                        groupName = it.group,
                        tvgId = it.tvgId
                    )
                }

            channelDao.deleteByPlaylistId(playlistId)
            channelDao.insertAll(channels)
        }
    }

    override suspend fun setFavorite(channelId: Long, isFavorite: Boolean) {
        channelDao.setFavorite(channelId, isFavorite)
    }
}
