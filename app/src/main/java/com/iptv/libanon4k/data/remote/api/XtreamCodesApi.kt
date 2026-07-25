package com.iptv.libanon4k.data.remote.api

import com.iptv.libanon4k.data.remote.dto.CategoryDto
import com.iptv.libanon4k.data.remote.dto.ChannelDto
import com.iptv.libanon4k.data.remote.dto.MovieDto
import com.iptv.libanon4k.data.remote.dto.SeriesDto
import com.iptv.libanon4k.data.remote.dto.VodDto
import retrofit2.http.GET
import retrofit2.http.Query

interface XtreamCodesApi {

    @GET("get.php")
    suspend fun getCategories(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_categories"
    ): List<CategoryDto>

    @GET("get.php")
    suspend fun getLiveChannels(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_live_channels"
    ): List<ChannelDto>

    @GET("get.php")
    suspend fun getLiveChannelsByCategory(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("category_id") categoryId: String,
        @Query("action") action: String = "get_live_channels"
    ): List<ChannelDto>

    @GET("get.php")
    suspend fun getMovies(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_vod_streams"
    ): List<MovieDto>

    @GET("get.php")
    suspend fun getMoviesByCategory(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("category_id") categoryId: String,
        @Query("action") action: String = "get_vod_streams"
    ): List<MovieDto>

    @GET("get.php")
    suspend fun getSeries(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_series"
    ): List<SeriesDto>

    @GET("get.php")
    suspend fun getSeriesByCategory(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("category_id") categoryId: String,
        @Query("action") action: String = "get_series"
    ): List<SeriesDto>

    @GET("get.php")
    suspend fun getSeriesInfo(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_series_info",
        @Query("series_id") seriesId: String
    ): VodDto
}
