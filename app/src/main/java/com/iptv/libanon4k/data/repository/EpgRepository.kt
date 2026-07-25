package com.iptv.libanon4k.data.repository

import com.iptv.libanon4k.data.local.dao.EpgDao
import com.iptv.libanon4k.data.model.EpgProgram
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpgRepository @Inject constructor(
    private val epgDao: EpgDao
) {

    suspend fun insertPrograms(programs: List<EpgProgram>) {
        epgDao.insertPrograms(programs)
    }

    suspend fun getCurrentProgram(channelId: String): EpgProgram? {
        return epgDao.getCurrentProgram(channelId, System.currentTimeMillis())
    }

    suspend fun getNextProgram(channelId: String): EpgProgram? {
        return epgDao.getNextProgram(channelId, System.currentTimeMillis())
    }

    fun getProgramsByTimeRange(
        channelId: String,
        startTime: Long,
        endTime: Long
    ): Flow<List<EpgProgram>> {
        return epgDao.getProgramsByTimeRange(channelId, startTime, endTime)
    }

    suspend fun deleteAllPrograms() {
        epgDao.deleteAllPrograms()
    }
}
