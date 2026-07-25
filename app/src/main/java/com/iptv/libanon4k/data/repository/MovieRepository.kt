package com.iptv.libanon4k.data.repository

import com.iptv.libanon4k.data.local.dao.MovieDao
import com.iptv.libanon4k.data.local.dao.RecentlyWatchedDao
import com.iptv.libanon4k.data.model.Movie
import com.iptv.libanon4k.data.model.RecentlyWatched
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDao: MovieDao,
    private val recentlyWatchedDao: RecentlyWatchedDao
) {

    fun getMoviesByCategory(accountId: Long, categoryId: String): Flow<List<Movie>> =
        movieDao.getMoviesByCategory(accountId, categoryId)

    fun getMoviesByAccount(accountId: Long): Flow<List<Movie>> =
        movieDao.getMoviesByAccount(accountId)

    fun getFavoriteMovies(accountId: Long): Flow<List<Movie>> =
        movieDao.getFavoriteMovies(accountId)

    fun searchMovies(accountId: Long, query: String): Flow<List<Movie>> =
        movieDao.searchMovies(accountId, "%$query%")

    fun getContinueWatchingMovies(accountId: Long): Flow<List<Movie>> =
        movieDao.getContinueWatchingMovies(accountId)

    suspend fun insertMovies(movies: List<Movie>) {
        movieDao.insertMovies(movies)
    }

    suspend fun getMovieById(id: String): Movie? = movieDao.getMovieById(id)

    suspend fun addToFavorites(id: String) {
        movieDao.addToFavorites(id)
    }

    suspend fun removeFromFavorites(id: String) {
        movieDao.removeFromFavorites(id)
    }

    suspend fun updateProgress(movieId: String, progress: Long) {
        movieDao.updateProgress(movieId, progress, System.currentTimeMillis())
    }

    suspend fun recordWatchHistory(movie: Movie, progress: Long) {
        val recentlyWatched = RecentlyWatched(
            id = movie.id,
            accountId = 0,
            contentId = movie.id,
            contentType = "movie",
            title = movie.title,
            poster = movie.poster,
            lastWatchedTime = System.currentTimeMillis(),
            duration = movie.duration,
            watchedProgress = progress
        )
        recentlyWatchedDao.insertRecentlyWatched(recentlyWatched)
    }
}
