package com.walter.pokedata.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.walter.pokedata.navigation.route.MainNavController
import com.walter.pokedata.presentation.components.PokeDexSwitch
import com.walter.pokedata.presentation.components.PokeDexTopAppBar


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
    }
}
