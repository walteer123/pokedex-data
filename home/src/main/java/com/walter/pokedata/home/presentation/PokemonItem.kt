package com.walter.pokedata.home.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.walter.pokedata.home.domain.entity.Pokemon

@Composable
fun PokemonItem(pokemon: Pokemon, onClick: () -> Unit, ) {
    Row {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemon.imageUrl)
                .crossfade(true)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Text(modifier = Modifier.fillMaxWidth().weight(1f), text = pokemon.name)
        PokemonItemFavButton(
            isFavorite = true,
            onClick = onClick,
        )
    }
}

@Preview
@Composable
fun PreviewPokemonItem() {
    val pokemon = Pokemon(
        name = "Charizard",
        imageUrl = "teste"
    )
    Surface {
        PokemonItem(pokemon = pokemon ) {

        }
    }

}