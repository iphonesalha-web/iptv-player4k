package com.iptv.player4k.data.remote.m3u

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class M3uRemoteDataSource(
    private val client: OkHttpClient
) {
    private val parser = M3uParser()

    suspend fun fetchChannels(url: String): List<M3uChannel> = withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IllegalStateException("Failed to load playlist: ${response.code}")
            }

            val body = response.body?.string().orEmpty()
            parser.parse(body)
        }
    }
}
