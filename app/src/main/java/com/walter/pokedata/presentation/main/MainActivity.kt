package com.walter.pokedata.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material3.Text
import androidx.databinding.DataBindingUtil
import com.walter.pokedata.R
import com.walter.pokedata.databinding.ActivityMainBinding
import com.walter.pokedata.navigation.route.MainNavController
import com.walter.pokedata.shared.Greeting


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                topAppBar = {
                    PokeDexTopAppBar(
                        title = {
                            Text(text = "Pokemon Data Home")
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
