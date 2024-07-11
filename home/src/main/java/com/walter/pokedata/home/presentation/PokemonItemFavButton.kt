package com.walter.pokedata.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.walter.pokedata.home.R

@Composable
fun PokemonItemFavButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isFavorite: Boolean = false,
) {
    var isChecked by remember { mutableStateOf(isFavorite) }
    Column(
        modifier = modifier
            .padding(12.dp)
            .toggleable(
                value = isChecked,
                onValueChange = {
                    isChecked = it
                    onClick()
                }
            )
            .clip(RoundedCornerShape(size = 20.dp))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_star_full),
            contentDescription = null,
            tint = if (isChecked) Color(0xFFFFc107) else Color.Gray,
        )
    }

}

@Preview
@Composable
fun PreviewPokemonItemFavButton() {
    PokemonItemFavButton(isFavorite = false)
}