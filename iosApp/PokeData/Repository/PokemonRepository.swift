import Foundation
import shared

class PokemonRepository {
    let service: PokemonService

    init() {
        self.service = KoinDependencies.shared.pokemonService
    }
    
    @MainActor
    func fetchPokemonData(defOffset: Int = 0) async -> [Pokemon]? {
        if let data = try? await service.fetchPokemonList(limit: 60,offset: Int32(defOffset)) {
            return data.results.map {
                $0.transform()
            }
        }
        return nil
    }
}
