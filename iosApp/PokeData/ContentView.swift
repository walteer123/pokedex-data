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
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
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
