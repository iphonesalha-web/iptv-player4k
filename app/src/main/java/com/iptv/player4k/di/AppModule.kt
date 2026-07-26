package com.iptv.player4k.di

import android.content.Context
import androidx.room.Room
import com.iptv.player4k.data.local.dao.ChannelDao
import com.iptv.player4k.data.local.dao.PlaylistDao
import com.iptv.player4k.data.local.db.AppDatabase
import com.iptv.player4k.data.remote.m3u.M3uRemoteDataSource
import com.iptv.player4k.data.repository.ChannelRepository
import com.iptv.player4k.data.repository.ChannelRepositoryImpl
import com.iptv.player4k.data.repository.PlaylistRepository
import com.iptv.player4k.data.repository.PlaylistRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "iptv_player4k.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun providePlaylistDao(db: AppDatabase): PlaylistDao = db.playlistDao()

    @Provides
    fun provideChannelDao(db: AppDatabase): ChannelDao = db.channelDao()

    @Provides
    @Singleton
    fun provideM3uRemoteDataSource(client: OkHttpClient): M3uRemoteDataSource =
        M3uRemoteDataSource(client)

    @Provides
    @Singleton
    fun providePlaylistRepository(playlistDao: PlaylistDao): PlaylistRepository =
        PlaylistRepositoryImpl(playlistDao)

    @Provides
    @Singleton
    fun provideChannelRepository(
        channelDao: ChannelDao,
        playlistDao: PlaylistDao,
        remoteDataSource: M3uRemoteDataSource
    ): ChannelRepository = ChannelRepositoryImpl(channelDao, playlistDao, remoteDataSource)
}
