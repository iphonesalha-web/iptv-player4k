package com.iptv.libanon4k.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iptv.libanon4k.data.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movie>)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM movies WHERE accountId = :accountId")
    suspend fun deleteMoviesByAccount(accountId: Long)

    @Query("SELECT * FROM movies WHERE id = :id")
    suspend fun getMovieById(id: String): Movie?

    @Query("SELECT * FROM movies WHERE accountId = :accountId AND categoryId = :categoryId ORDER BY title ASC")
    fun getMoviesByCategory(accountId: Long, categoryId: String): Flow<List<Movie>>

    @Query("SELECT * FROM movies WHERE accountId = :accountId ORDER BY title ASC")
    fun getMoviesByAccount(accountId: Long): Flow<List<Movie>>

    @Query("SELECT * FROM movies WHERE accountId = :accountId AND isFavorite = 1 ORDER BY title ASC")
    fun getFavoriteMovies(accountId: Long): Flow<List<Movie>>

    @Query("SELECT * FROM movies WHERE accountId = :accountId AND title LIKE :query ORDER BY title ASC")
    fun searchMovies(accountId: Long, query: String): Flow<List<Movie>>

    @Query("SELECT * FROM movies WHERE accountId = :accountId AND watchedProgress > 0 ORDER BY lastWatchedTime DESC")
    fun getContinueWatchingMovies(accountId: Long): Flow<List<Movie>>

    @Query("UPDATE movies SET isFavorite = 1 WHERE id = :id")
    suspend fun addToFavorites(id: String)

    @Query("UPDATE movies SET isFavorite = 0 WHERE id = :id")
    suspend fun removeFromFavorites(id: String)

    @Query("UPDATE movies SET watchedProgress = :progress, lastWatchedTime = :time WHERE id = :id")
    suspend fun updateProgress(id: String, progress: Long, time: Long)
}
