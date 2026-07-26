package com.iptv.player4k.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iptv.player4k.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSettingsInfo.text = "Basic IPTV MVP settings screen"
    }
}
