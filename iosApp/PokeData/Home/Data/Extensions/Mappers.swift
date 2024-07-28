//
//  Mappers.swift
//  PokeData
//
//  Created by Walter Alves on 21/07/24.
//

import Foundation
import shared

extension PokemonRemote {
    func transform() -> Pokemon {
        return Pokemon(name: self.name, imageUrl: DataExtensionsKt.getImageUrl(pokemonRemote: self))
    }
}
