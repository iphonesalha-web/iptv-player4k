package com.iptv.libanon4k.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iptv.libanon4k.data.model.EpgProgram
import kotlinx.coroutines.flow.Flow

@Dao
interface EpgDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgram(program: EpgProgram)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrograms(programs: List<EpgProgram>)

    @Query("DELETE FROM epg_programs WHERE channelId = :channelId")
    suspend fun deleteProgramsByChannel(channelId: String)

    @Query("DELETE FROM epg_programs")
    suspend fun deleteAllPrograms()

    @Query("SELECT * FROM epg_programs WHERE channelId = :channelId AND startTime <= :currentTime AND endTime > :currentTime LIMIT 1")
    suspend fun getCurrentProgram(channelId: String, currentTime: Long): EpgProgram?

    @Query("SELECT * FROM epg_programs WHERE channelId = :channelId AND startTime > :currentTime ORDER BY startTime ASC LIMIT 1")
    suspend fun getNextProgram(channelId: String, currentTime: Long): EpgProgram?

    @Query("SELECT * FROM epg_programs WHERE channelId = :channelId AND startTime >= :startTime AND startTime < :endTime ORDER BY startTime ASC")
    fun getProgramsByTimeRange(channelId: String, startTime: Long, endTime: Long): Flow<List<EpgProgram>>
}
