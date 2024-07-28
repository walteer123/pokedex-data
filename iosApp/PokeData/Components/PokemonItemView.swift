//
//  SwiftUIView.swift
//  PokeData
//
//  Created by Walter Alves on 21/07/24.
//

import SwiftUI

struct PokemonItemView: View {
    var pokemon: Pokemon
    var pokemonUrl : URL?
    init(pokemon: Pokemon) {
        self.pokemon = pokemon
        self.pokemonUrl = URL(string: pokemon.imageUrl)
    }
    
    var body: some View {
        HStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/) {
            AsyncImage(url: pokemonUrl) { image in
                image.resizable()
                    .frame(width: 80, height: 80)
            } placeholder: {
                ProgressView()
                    .frame(width: 80, height: 80)
            }
            Text(pokemon.name)
                .frame(maxWidth: .infinity)
                .multilineTextAlignment(/*@START_MENU_TOKEN@*/.leading/*@END_MENU_TOKEN@*/)
        
            Button {
                
            } label: {
                Image(systemName: "star.fill")
            }.frame(alignment: .center)
        }.frame(minWidth: 0, maxWidth: .infinity)
    }
}

#Preview {
    PokemonItemView(pokemon: Pokemon(name: "teste", imageUrl: ""))
}
