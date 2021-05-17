package com.walter.pokedata.presentation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import com.walter.pokedata.domain.entity.WifiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@AndroidEntryPoint
class WifiStateReceiver @Inject constructor() : BroadcastReceiver() {

    val connectionFLow : StateFlow<WifiState> get() = _connectionFlow
    private val _connectionFlow = MutableStateFlow(WifiState.CONNECTED)

    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)) {
            WifiManager.WIFI_STATE_ENABLED -> _connectionFlow.value = WifiState.CONNECTED
            WifiManager.WIFI_STATE_DISABLED-> _connectionFlow.value = WifiState.DISCONNECTED
        }
    }

}
