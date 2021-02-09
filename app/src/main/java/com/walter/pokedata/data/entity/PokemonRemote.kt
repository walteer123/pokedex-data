package com.walter.pokedata.data.entity

import com.squareup.moshi.Json
import com.walter.pokedata.domain.Pokemon

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
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }
}