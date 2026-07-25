package com.iptv.player4k.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iptv.player4k.data.models.Channel
import com.iptv.player4k.data.models.Playlist
import com.iptv.player4k.data.repository.ChannelRepository
import com.iptv.player4k.data.repository.PlaylistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val playlistRepository: PlaylistRepository,
    private val channelRepository: ChannelRepository
) : ViewModel() {

    private val _connectionStatus = MutableStateFlow(false)
    val connectionStatus: StateFlow<Boolean> = _connectionStatus.asStateFlow()

    private val _currentServer = MutableStateFlow("maripor.com")
    val currentServer: StateFlow<String> = _currentServer.asStateFlow()

    private val _expiryDate = MutableStateFlow("01-06-2026")
    val expiryDate: StateFlow<String> = _expiryDate.asStateFlow()

    private val _playlists = MutableStateFlow<List<Playlist>>(emptyList())
    val playlists: StateFlow<List<Playlist>> = _playlists.asStateFlow()

    private val _channels = MutableStateFlow<List<Channel>>(emptyList())
    val channels: StateFlow<List<Channel>> = _channels.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadInitialData()
        startTimeUpdater()
    }

    fun loadConnectionStatus() {
        viewModelScope.launch {
            try {
                _connectionStatus.value = checkConnection()
            } catch (e: Exception) {
                _connectionStatus.value = false
            }
        }
    }

    fun loadServerInfo() {
        viewModelScope.launch {
            try {
                // Load from preferences or database
                _currentServer.value = getServerFromPreferences()
                _expiryDate.value = getExpiryDateFromPreferences()
            } catch (e: Exception) {
                // Use default values
            }
        }
    }

    fun loadAllChannels() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val allChannels = channelRepository.getAllChannels()
                _channels.value = allChannels
            } catch (e: Exception) {
                _channels.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadAllPlaylists() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val allPlaylists = playlistRepository.getAllPlaylists()
                _playlists.value = allPlaylists
            } catch (e: Exception) {
                _playlists.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addPlaylist(url: String, name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val playlist = Playlist(
                    id = 0,
                    name = name,
                    url = url,
                    createdAt = System.currentTimeMillis(),
                    updatedAt = System.currentTimeMillis()
                )
                playlistRepository.insertPlaylist(playlist)
                loadAllPlaylists()
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deletePlaylist(playlistId: Long) {
        viewModelScope.launch {
            try {
                playlistRepository.deletePlaylist(playlistId)
                loadAllPlaylists()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            loadConnectionStatus()
            loadServerInfo()
            loadAllPlaylists()
            loadAllChannels()
        }
    }

    private suspend fun checkConnection(): Boolean {
        return try {
            // Perform a simple ping or connection check
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun getServerFromPreferences(): String {
        // Implementation depends on preferences management
        return "maripor.com"
    }

    private fun getExpiryDateFromPreferences(): String {
        // Implementation depends on preferences management
        return "01-06-2026"
    }

    private fun startTimeUpdater() {
        viewModelScope.launch {
            while (true) {
                updateTime()
                kotlinx.coroutines.delay(60000) // Update every minute
            }
        }
    }

    private fun updateTime() {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = sdf.format(Date())
        // Emit current time if needed
    }
}
