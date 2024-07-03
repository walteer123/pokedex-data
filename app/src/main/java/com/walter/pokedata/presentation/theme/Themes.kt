package com.walter.pokedata.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.walter.pokedata.presentation.theme.colors.black
import com.walter.pokedata.presentation.theme.colors.black_primary
import com.walter.pokedata.presentation.theme.colors.black_variant
import com.walter.pokedata.presentation.theme.colors.red_400
import com.walter.pokedata.presentation.theme.colors.red_400_dark
import com.walter.pokedata.presentation.theme.colors.yellow_800
import com.walter.pokedata.presentation.theme.colors.yellow_800_dark
import com.walter.pokedata.presentation.theme.colors.yellow_800_light

private val LightTheme = lightColorScheme(
    primary = red_400,
    primaryContainer = red_400_dark,
    onPrimary = Color.White,
    secondary = yellow_800,
    secondaryContainer = yellow_800_dark,
    onSecondary = Color.White,
)

private val DarkTheme = darkColorScheme(
    primary = black_primary,
    primaryContainer = black_variant,
    onPrimary = black,
    secondary = yellow_800,
    secondaryContainer = yellow_800_dark,
    onSecondary = Color.White
)

@Composable
fun PokeDataAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!darkTheme) {
        LightTheme
    } else {
        DarkTheme
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pokeDexAppBarColors(darkTheme: Boolean = false) = TopAppBarColors(
    containerColor = if (darkTheme) black_primary else red_400,
    scrolledContainerColor = if (darkTheme) black_primary else red_400,
    navigationIconContentColor = Color.White,
    titleContentColor = Color.White,
    actionIconContentColor = Color.White
)

@Composable
fun pokeDexSwitchColors() = SwitchDefaults.colors(
    checkedTrackColor = yellow_800,
)
