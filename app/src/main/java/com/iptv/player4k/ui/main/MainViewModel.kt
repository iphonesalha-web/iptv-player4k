package com.iptv.player4k.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iptv.player4k.data.local.entity.ChannelEntity
import com.iptv.player4k.data.repository.ChannelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val channelRepository: ChannelRepository
) : ViewModel() {

    val channels = channelRepository.observeChannels()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _message = MutableStateFlow<String?>(null)
    val message: StateFlow<String?> = _message.asStateFlow()

    fun importPlaylist(name: String, url: String) {
        viewModelScope.launch {
            _loading.value = true
            val result = channelRepository.importPlaylist(name, url)
            _loading.value = false
            _message.value = result.exceptionOrNull()?.message ?: "Playlist imported successfully"
        }
    }

    fun toggleFavorite(channel: ChannelEntity) {
        viewModelScope.launch {
            channelRepository.setFavorite(channel.id, !channel.isFavorite)
        }
    }

    fun clearMessage() {
        _message.value = null
    }
}
