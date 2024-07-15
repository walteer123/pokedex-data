//
//  PokeDataApp.swift
//  PokeData
//
//  Created by Walter Alves on 09/07/24.
//

import SwiftUI
import shared
@main
struct PokeDataApp: App {
    init() {
        HelperKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
