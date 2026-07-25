package com.iptv.libanon4k.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("category_name")
    val categoryName: String,
    @SerializedName("parent_id")
    val parentId: String? = null
)

data class ChannelDto(
    @SerializedName("num")
    val number: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("stream_id")
    val streamId: String,
    @SerializedName("stream_icon")
    val logo: String = "",
    @SerializedName("epg_channel_id")
    val epgChannelId: String = "",
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("added")
    val added: String = "",
    @SerializedName("is_adult")
    val isAdult: String = "0",
    @SerializedName("custom_sid")
    val customSid: String = ""
)

data class MovieDto(
    @SerializedName("num")
    val number: Int,
    @SerializedName("name")
    val title: String,
    @SerializedName("stream_id")
    val streamId: String,
    @SerializedName("stream_icon")
    val poster: String = "",
    @SerializedName("rating")
    val rating: String = "",
    @SerializedName("rating_5based")
    val ratingFiveBased: String = "",
    @SerializedName("added")
    val added: String = "",
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("container_extension")
    val containerExtension: String = "mkv",
    @SerializedName("custom_sid")
    val customSid: String = "",
    @SerializedName("direct_source")
    val directSource: String = ""
)

data class SeriesDto(
    @SerializedName("series_id")
    val seriesId: String,
    @SerializedName("name")
    val title: String,
    @SerializedName("cover")
    val poster: String = "",
    @SerializedName("plot")
    val description: String = "",
    @SerializedName("backdrop")
    val backdrop: String = "",
    @SerializedName("rating")
    val rating: String = "",
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("added")
    val added: String = ""
)

data class VodDto(
    @SerializedName("info")
    val info: SeriesInfoDto? = null,
    @SerializedName("seasons")
    val seasons: Map<String, List<EpisodeDto>> = emptyMap()
)

data class SeriesInfoDto(
    @SerializedName("series_id")
    val seriesId: String,
    @SerializedName("name")
    val title: String,
    @SerializedName("cover")
    val poster: String = "",
    @SerializedName("plot")
    val description: String = "",
    @SerializedName("backdrop")
    val backdrop: String = "",
    @SerializedName("rating")
    val rating: String = ""
)

data class EpisodeDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("season")
    val season: Int,
    @SerializedName("episode_num")
    val episodeNum: Int,
    @SerializedName("still")
    val thumbnail: String = "",
    @SerializedName("plot")
    val description: String = "",
    @SerializedName("duration")
    val duration: String = "0"
)
