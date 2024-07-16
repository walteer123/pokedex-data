//
//  ContentView.swift
//  PokeData
//
//  Created by Walter Alves on 09/07/24.
//

import SwiftUI

struct ContentView: View {
    var viewModel = HomeViewModel()
    
    var body: some View {
        
        ScrollView {
            LazyVStack(alignment: .leading) {
                ForEach(viewModel.pokemonResponse.indices, id: \.self) { index in
                    let item = viewModel.pokemonResponse[index]
                   
                    Text(item.name).task {
                        if index == viewModel.pokemonResponse.count - 1 {
                            await viewModel.getPokemons()
                        }
                    }
                    
                }
            }
        }
        .padding()
        .task {
            await viewModel.getPokemons()
        }
    }
}

#Preview {
    ContentView()
}
