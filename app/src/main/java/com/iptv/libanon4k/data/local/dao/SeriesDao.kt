package com.iptv.libanon4k.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iptv.libanon4k.data.model.Series
import kotlinx.coroutines.flow.Flow

@Dao
interface SeriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(series: Series)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeriesList(series: List<Series>)

    @Update
    suspend fun updateSeries(series: Series)

    @Delete
    suspend fun deleteSeries(series: Series)

    @Query("DELETE FROM series WHERE accountId = :accountId")
    suspend fun deleteSeriesByAccount(accountId: Long)

    @Query("SELECT * FROM series WHERE id = :id")
    suspend fun getSeriesById(id: String): Series?

    @Query("SELECT * FROM series WHERE accountId = :accountId AND categoryId = :categoryId ORDER BY title ASC")
    fun getSeriesByCategory(accountId: Long, categoryId: String): Flow<List<Series>>

    @Query("SELECT * FROM series WHERE accountId = :accountId ORDER BY title ASC")
    fun getSeriesByAccount(accountId: Long): Flow<List<Series>>

    @Query("SELECT * FROM series WHERE accountId = :accountId AND isFavorite = 1 ORDER BY title ASC")
    fun getFavoriteSeries(accountId: Long): Flow<List<Series>>

    @Query("SELECT * FROM series WHERE accountId = :accountId AND title LIKE :query ORDER BY title ASC")
    fun searchSeries(accountId: Long, query: String): Flow<List<Series>>

    @Query("UPDATE series SET isFavorite = 1 WHERE id = :id")
    suspend fun addToFavorites(id: String)

    @Query("UPDATE series SET isFavorite = 0 WHERE id = :id")
    suspend fun removeFromFavorites(id: String)
}
