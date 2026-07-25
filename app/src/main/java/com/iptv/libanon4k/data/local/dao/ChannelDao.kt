package com.iptv.libanon4k.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iptv.libanon4k.data.model.Channel
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChannel(channel: Channel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChannels(channels: List<Channel>)

    @Update
    suspend fun updateChannel(channel: Channel)

    @Delete
    suspend fun deleteChannel(channel: Channel)

    @Query("DELETE FROM channels WHERE accountId = :accountId")
    suspend fun deleteChannelsByAccount(accountId: Long)

    @Query("SELECT * FROM channels WHERE id = :id")
    suspend fun getChannelById(id: String): Channel?

    @Query("SELECT * FROM channels WHERE accountId = :accountId AND categoryId = :categoryId ORDER BY number ASC, name ASC")
    fun getChannelsByCategory(accountId: Long, categoryId: String): Flow<List<Channel>>

    @Query("SELECT * FROM channels WHERE accountId = :accountId ORDER BY number ASC, name ASC")
    fun getChannelsByAccount(accountId: Long): Flow<List<Channel>>

    @Query("SELECT * FROM channels WHERE accountId = :accountId AND isFavorite = 1 ORDER BY number ASC")
    fun getFavoriteChannels(accountId: Long): Flow<List<Channel>>

    @Query("SELECT * FROM channels WHERE accountId = :accountId AND name LIKE :query ORDER BY number ASC")
    fun searchChannels(accountId: Long, query: String): Flow<List<Channel>>

    @Query("UPDATE channels SET isFavorite = 1 WHERE id = :id")
    suspend fun addToFavorites(id: String)

    @Query("UPDATE channels SET isFavorite = 0 WHERE id = :id")
    suspend fun removeFromFavorites(id: String)

    @Query("UPDATE channels SET lastWatchedTime = :time, lastWatchedDuration = :duration WHERE id = :id")
    suspend fun updateLastWatched(id: String, time: Long, duration: Long)
}
