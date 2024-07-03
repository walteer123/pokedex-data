package com.walter.pokedata.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.walter.pokedata.presentation.theme.pokeDexAppBarColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeDexTopAppBar(
    darkTheme: Boolean = false,
    title: @Composable (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null
){
    TopAppBar(
        colors = pokeDexAppBarColors(darkTheme),
        title = { title?.invoke() },
        actions = {
            actions?.invoke()
        }
    )
}