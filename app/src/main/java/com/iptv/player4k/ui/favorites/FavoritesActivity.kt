package com.iptv.player4k.ui.favorites

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iptv.player4k.databinding.ActivityFavoritesBinding
import com.iptv.player4k.ui.main.ChannelAdapter
import com.iptv.player4k.ui.player.PlayerActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritesBinding
    private val viewModel: FavoritesViewModel by viewModels()
    private lateinit var adapter: ChannelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ChannelAdapter(
            onClick = { channel ->
                startActivity(
                    Intent(this, PlayerActivity::class.java)
                        .putExtra(PlayerActivity.EXTRA_URL, channel.streamUrl)
                        .putExtra(PlayerActivity.EXTRA_NAME, channel.name)
                )
            },
            onFavoriteClick = { channel ->
                viewModel.toggleFavorite(channel.id, channel.isFavorite)
            }
        )

        binding.recyclerFavorites.layoutManager = LinearLayoutManager(this)
        binding.recyclerFavorites.adapter = adapter

        lifecycleScope.launch {
            viewModel.favorites.collect {
                adapter.submitList(it)
            }
        }
    }
}
