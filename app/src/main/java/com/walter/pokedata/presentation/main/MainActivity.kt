package com.walter.pokedata.presentation.main

import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.walter.pokedata.R
import com.walter.pokedata.databinding.ActivityMainBinding
import com.walter.pokedata.presentation.receiver.WifiStateReceiver
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var wifiStateReceiver: WifiStateReceiver

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        registerReceiver(wifiStateReceiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
        observeDarkModeToggle(binding)
        collectConnectionReceiver()
        collectStates(binding)
    }

    private fun collectStates(binding: ActivityMainBinding) {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                when (state) {
                    is MainState.ConnectionData -> renderConnectionMessage(state.message, binding)
                }
            }
        }
    }

    private fun renderConnectionMessage(message: String, binding: ActivityMainBinding) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun collectConnectionReceiver() {
        lifecycleScope.launchWhenStarted {
            wifiStateReceiver.connectionFLow.collect {
                viewModel.interact(MainInteraction.UpdateConnectionStatus(it))
            }
        }
    }

    private fun observeDarkModeToggle(binding: ActivityMainBinding) {
        binding.darkModeToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }
}
