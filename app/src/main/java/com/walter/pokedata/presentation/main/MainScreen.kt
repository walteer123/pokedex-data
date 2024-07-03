package com.walter.pokedata.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walter.pokedata.presentation.theme.PokeDataAppTheme
import com.walter.pokedata.presentation.theme.pokeDexAppBarColors
import com.walter.pokedata.presentation.theme.pokeDexSwitchColors

@Composable
fun MainScreen(
    darkTheme: Boolean = false,
    topAppBar:@Composable (() -> Unit)? = null,
    content:@Composable (() -> Unit)? = null,
) {
    PokeDataAppTheme(
        darkTheme = darkTheme
    ) {
        Surface {
            Column {
                topAppBar?.invoke()
                content?.invoke()
            }
        }
    }

}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}