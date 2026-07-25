package com.iptv.libanon4k.data.repository

import com.iptv.libanon4k.data.local.dao.EpisodeDao
import com.iptv.libanon4k.data.local.dao.SeriesDao
import com.iptv.libanon4k.data.model.Episode
import com.iptv.libanon4k.data.model.Series
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SeriesRepository @Inject constructor(
    private val seriesDao: SeriesDao,
    private val episodeDao: EpisodeDao
) {

    fun getSeriesByCategory(accountId: Long, categoryId: String): Flow<List<Series>> =
        seriesDao.getSeriesByCategory(accountId, categoryId)

    fun getSeriesByAccount(accountId: Long): Flow<List<Series>> =
        seriesDao.getSeriesByAccount(accountId)

    fun getFavoriteSeries(accountId: Long): Flow<List<Series>> =
        seriesDao.getFavoriteSeries(accountId)

    fun searchSeries(accountId: Long, query: String): Flow<List<Series>> =
        seriesDao.searchSeries(accountId, "%$query%")

    suspend fun insertSeries(series: List<Series>) {
        seriesDao.insertSeriesList(series)
    }

    suspend fun getSeriesById(id: String): Series? = seriesDao.getSeriesById(id)

    suspend fun addToFavorites(id: String) {
        seriesDao.addToFavorites(id)
    }

    suspend fun removeFromFavorites(id: String) {
        seriesDao.removeFromFavorites(id)
    }

    // Episodes
    fun getEpisodesBySeason(seriesId: String, seasonNumber: Int): Flow<List<Episode>> =
        episodeDao.getEpisodesBySeason(seriesId, seasonNumber)

    fun getEpisodesBySeries(seriesId: String): Flow<List<Episode>> =
        episodeDao.getEpisodesBySeries(seriesId)

    suspend fun insertEpisodes(episodes: List<Episode>) {
        episodeDao.insertEpisodes(episodes)
    }

    suspend fun getEpisodeById(id: String): Episode? = episodeDao.getEpisodeById(id)

    suspend fun updateEpisodeProgress(episodeId: String, progress: Long) {
        episodeDao.updateProgress(episodeId, progress, System.currentTimeMillis())
    }
}
