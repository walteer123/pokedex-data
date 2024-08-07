package com.walter.pokedata.shared.factory

import com.walter.pokedata.sql.PokemonDatabase

interface DatabaseServiceFactory {
    fun create(): PokemonDatabase
}