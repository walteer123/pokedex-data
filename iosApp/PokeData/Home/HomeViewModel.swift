//
//  HomeViewModel.swift
//  PokeData
//
//  Created by Walter Alves on 13/07/24.
//

import Foundation

@Observable
class HomeViewModel {
    
    let repository: PokemonRepository
    
    init() {
        self.repository = PokemonRepository() 
    }
    
    @MainActor
    func getPokemons() async {
        var pokemonResponse = await repository.fetchPokemonData()
        print(pokemonResponse)
    }
}
