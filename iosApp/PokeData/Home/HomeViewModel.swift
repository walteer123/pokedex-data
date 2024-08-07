//
//  HomeViewModel.swift
//  PokeData
//
//  Created by Walter Alves on 13/07/24.
//

import Foundation
import shared

@Observable
class HomeViewModel {
    
    let repository: PokemonRepository
    var pokemonResponse: [Pokemon] = []
    
    init() {
        self.repository = PokemonRepository() 
    }
    
    @MainActor
    func getPokemons() async {
        let data: [Pokemon]? = await repository.fetchPokemonData(defOffset: pokemonResponse.count) ?? nil
        pokemonResponse += data ?? []
    }
}
