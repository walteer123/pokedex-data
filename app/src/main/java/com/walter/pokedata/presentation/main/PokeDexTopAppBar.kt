package com.walter.pokedata.presentation.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.walter.pokedata.presentation.theme.pokeDexAppBarColors
import com.walter.pokedata.presentation.theme.pokeDexSwitchColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeDexTopAppBar(
    title: @Composable (() -> Unit)? = null
){
    TopAppBar(
        colors = pokeDexAppBarColors(),
        title = { title?.invoke() },
        actions = {
            Switch(
                checked = true,
                onCheckedChange = {},
                colors = pokeDexSwitchColors()
            )
        }
    )
}