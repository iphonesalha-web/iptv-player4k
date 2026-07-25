package com.iptv.libanon4k.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iptv.libanon4k.data.model.RecentlyWatched
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentlyWatchedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentlyWatched(item: RecentlyWatched)

    @Update
    suspend fun updateRecentlyWatched(item: RecentlyWatched)

    @Delete
    suspend fun deleteRecentlyWatched(item: RecentlyWatched)

    @Query("DELETE FROM recently_watched WHERE accountId = :accountId")
    suspend fun deleteByAccount(accountId: Long)

    @Query("SELECT * FROM recently_watched WHERE accountId = :accountId ORDER BY lastWatchedTime DESC LIMIT :limit")
    fun getRecentlyWatched(accountId: Long, limit: Int = 20): Flow<List<RecentlyWatched>>

    @Query("DELETE FROM recently_watched WHERE id = :id")
    suspend fun deleteById(id: String)

    @Query("SELECT * FROM recently_watched WHERE accountId = :accountId AND contentId = :contentId LIMIT 1")
    suspend fun getByContentId(accountId: Long, contentId: String): RecentlyWatched?
}
