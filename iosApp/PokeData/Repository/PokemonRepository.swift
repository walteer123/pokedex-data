import Foundation
import shared

class PokemonRepository {
    let service: PokemonService

    init() {
        self.service = KoinDependencies.shared.pokemonService
    }
    
    @MainActor
    func fetchPokemonData() async -> PokemonListResponse? {
      if let data = try? await service.fetchPokemonList(limit:20,offset: 0) { return data }
        return nil
    }
}
