package com.walter.pokedata.shared.data.mappers

import com.walter.pokedata.shared.domain.entity.Pokemon
import com.walter.pokedata.sql.PokemonEntity

fun PokemonEntity.transform() = Pokemon(
    name = name,
    imageUrl = imageUrl
)