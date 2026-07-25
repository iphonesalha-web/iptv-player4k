package com.iptv.libanon4k.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iptv.libanon4k.data.model.Episode
import kotlinx.coroutines.flow.Flow

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: Episode)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisodes(episodes: List<Episode>)

    @Update
    suspend fun updateEpisode(episode: Episode)

    @Delete
    suspend fun deleteEpisode(episode: Episode)

    @Query("DELETE FROM episodes WHERE seriesId = :seriesId")
    suspend fun deleteEpisodesBySeries(seriesId: String)

    @Query("SELECT * FROM episodes WHERE id = :id")
    suspend fun getEpisodeById(id: String): Episode?

    @Query("SELECT * FROM episodes WHERE seriesId = :seriesId ORDER BY seasonNumber ASC, episodeNumber ASC")
    fun getEpisodesBySeries(seriesId: String): Flow<List<Episode>>

    @Query("SELECT * FROM episodes WHERE seriesId = :seriesId AND seasonNumber = :seasonNumber ORDER BY episodeNumber ASC")
    fun getEpisodesBySeason(seriesId: String, seasonNumber: Int): Flow<List<Episode>>

    @Query("UPDATE episodes SET watchedProgress = :progress, lastWatchedTime = :time WHERE id = :id")
    suspend fun updateProgress(id: String, progress: Long, time: Long)
}
