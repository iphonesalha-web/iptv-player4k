package com.iptv.player4k.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iptv.player4k.databinding.ActivityMainBinding
import com.iptv.player4k.databinding.DialogAddPlaylistBinding
import com.iptv.player4k.ui.favorites.FavoritesActivity
import com.iptv.player4k.ui.player.PlayerActivity
import com.iptv.player4k.ui.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ChannelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()
        setupActions()
        observeState()
    }

    private fun setupList() {
        adapter = ChannelAdapter(
            onClick = { channel ->
                startActivity(
                    Intent(this, PlayerActivity::class.java)
                        .putExtra(PlayerActivity.EXTRA_URL, channel.streamUrl)
                        .putExtra(PlayerActivity.EXTRA_NAME, channel.name)
                )
            },
            onFavoriteClick = { channel ->
                viewModel.toggleFavorite(channel)
            }
        )

        binding.recyclerChannels.layoutManager = LinearLayoutManager(this)
        binding.recyclerChannels.adapter = adapter
    }

    private fun setupActions() {
        binding.btnAddPlaylist.setOnClickListener {
            showAddPlaylistDialog()
        }
        binding.btnFavorites.setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::class.java))
        }
        binding.btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            viewModel.channels.collect {
                adapter.submitList(it)
                binding.tvEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
            }
        }

        lifecycleScope.launch {
            viewModel.loading.collect {
                binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            }
        }

        lifecycleScope.launch {
            viewModel.message.collect { message ->
                if (message != null) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                    viewModel.clearMessage()
                }
            }
        }
    }

    private fun showAddPlaylistDialog() {
        val dialogBinding = DialogAddPlaylistBinding.inflate(layoutInflater)

        AlertDialog.Builder(this)
            .setTitle("Add Playlist")
            .setView(dialogBinding.root)
            .setPositiveButton("Import") { _, _ ->
                val name = dialogBinding.etPlaylistName.text.toString().trim()
                val url = dialogBinding.etPlaylistUrl.text.toString().trim()

                if (name.isNotBlank() && url.isNotBlank()) {
                    viewModel.importPlaylist(name, url)
                } else {
                    Toast.makeText(this, "Name and URL are required", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
