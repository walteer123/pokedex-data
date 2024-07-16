package com.walter.pokedata.shared.data.extensions

import com.walter.pokedata.shared.data.entity.PokemonRemote

fun PokemonRemote.getImageUrl(): String {
    val index = url?.split("/".toRegex())?.dropLast(1)?.last()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
}