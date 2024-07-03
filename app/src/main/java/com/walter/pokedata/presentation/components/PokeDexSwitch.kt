package com.walter.pokedata.presentation.components

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import com.walter.pokedata.presentation.theme.pokeDexSwitchColors

@Composable
fun PokeDexSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)? = null
){
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = pokeDexSwitchColors()
    )
}
