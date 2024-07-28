package com.walter.pokedata.home.data.extensions

import com.walter.pokedata.home.domain.entity.Pokemon
import com.walter.pokedata.shared.data.entity.PokemonRemote
import com.walter.pokedata.shared.data.extensions.getImageUrl

fun PokemonRemote.transform() = Pokemon(
    name = name,
    imageUrl = getImageUrl(this)
)
