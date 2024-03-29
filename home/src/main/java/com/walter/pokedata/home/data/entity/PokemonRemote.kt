package com.walter.pokedata.home.data.entity

import com.squareup.moshi.Json
import com.walter.pokedata.home.domain.entity.Pokemon

data class PokemonRemote(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val url: String?
) {
    fun transform() = Pokemon(
        name = name,
        imageUrl = getImageUrl()
    )

    private fun getImageUrl(): String {
        val index = url?.split("/".toRegex())?.dropLast(1)?.last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }
}
