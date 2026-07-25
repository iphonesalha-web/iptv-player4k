package com.iptv.player4k.ui.activities

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.leanback.app.GuidedStepSupportFragment
import androidx.lifecycle.lifecycleScope
import com.iptv.player4k.R
import com.iptv.player4k.databinding.ActivityMainBinding
import com.iptv.player4k.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        observeViewModel()
        loadInitialData()
    }

    private fun setupUI() {
        // Setup button listeners
        binding.btnAddPlaylist.setOnClickListener {
            showPlaylistDialog()
        }

        binding.btnChangeServer.setOnClickListener {
            showServerDialog()
        }

        binding.btnSettings.setOnClickListener {
            openSettings()
        }

        binding.btnLiveTV.setOnClickListener {
            navigateToChannels("LIVE")
        }

        binding.btnMovies.setOnClickListener {
            navigateToChannels("MOVIES")
        }

        binding.btnTVSeries.setOnClickListener {
            navigateToChannels("SERIES")
        }

        binding.btnCatchUp.setOnClickListener {
            navigateToChannels("CATCHUP")
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.connectionStatus.collect { status ->
                updateConnectionUI(status)
            }
        }

        lifecycleScope.launch {
            viewModel.currentServer.collect { server ->
                binding.tvServerName.text = server
            }
        }

        lifecycleScope.launch {
            viewModel.expiryDate.collect { date ->
                binding.tvExpiryDate.text = date
            }
        }
    }

    private fun loadInitialData() {
        lifecycleScope.launch {
            viewModel.loadConnectionStatus()
            viewModel.loadServerInfo()
        }
    }

    private fun updateConnectionUI(isConnected: Boolean) {
        binding.apply {
            if (isConnected) {
                ivConnectionStatus.setImageResource(R.drawable.ic_connected)
                tvConnectionStatus.text = "CONNECTED"
                tvConnectionStatus.setTextColor(resources.getColor(R.color.status_success, null))
            } else {
                ivConnectionStatus.setImageResource(R.drawable.ic_disconnected)
                tvConnectionStatus.text = "DISCONNECTED"
                tvConnectionStatus.setTextColor(resources.getColor(R.color.status_error, null))
            }
        }
    }

    private fun showPlaylistDialog() {
        // Show dialog to add playlist
        // Can be URL or file
    }

    private fun showServerDialog() {
        // Show server selection dialog
    }

    private fun openSettings() {
        // Open settings activity
    }

    private fun navigateToChannels(type: String) {
        // Navigate to channels based on type
        // LIVE, MOVIES, SERIES, CATCHUP
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                handleDpadLeft()
                true
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                handleDpadRight()
                true
            }
            KeyEvent.KEYCODE_DPAD_UP -> {
                handleDpadUp()
                true
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                handleDpadDown()
                true
            }
            KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> {
                handleSelect()
                true
            }
            else -> super.onKeyDown(keyCode, event)
        }
    }

    private fun handleDpadLeft() {
        // Handle left navigation
    }

    private fun handleDpadRight() {
        // Handle right navigation
    }

    private fun handleDpadUp() {
        // Handle up navigation
    }

    private fun handleDpadDown() {
        // Handle down navigation
    }

    private fun handleSelect() {
        // Handle select/enter
    }
}
