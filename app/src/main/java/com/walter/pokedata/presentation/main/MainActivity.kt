package com.walter.pokedata.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.databinding.DataBindingUtil
import com.walter.pokedata.R
import com.walter.pokedata.databinding.ActivityMainBinding
import com.walter.pokedata.navigation.route.MainNavController
import com.walter.pokedata.presentation.components.PokeDexSwitch
import com.walter.pokedata.presentation.components.PokeDexTopAppBar
import com.walter.pokedata.presentation.theme.pokeDexSwitchColors
import com.walter.pokedata.shared.Greeting


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkTheme = isSystemInDarkTheme()
            var onCheckedState by remember { mutableStateOf(darkTheme) }
            MainScreen(
                darkTheme = onCheckedState,
                topAppBar = {
                    PokeDexTopAppBar(
                        darkTheme = onCheckedState,
                        title = {
                            Text(text = "Pokemon Data Home")
                        },
                        actions = {
                            PokeDexSwitch(
                                checked = onCheckedState,
                                onCheckedChange = {
                                    onCheckedState = !onCheckedState
                                }
                            )
                        }
                    )
                },
                content = {
                    MainNavController()
                }
            )
        }
//        val binding =
//            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        observeDarkModeToggle(binding)
//        Log.i("Login Activity", "Hello from shared module: " + (Greeting().greet()))
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
}
