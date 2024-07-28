//
//  Pokemon.swift
//  PokeData
//
//  Created by Walter Alves on 21/07/24.
//

import Foundation

struct Pokemon {
    var name: String
    var imageUrl: String
    
    init(name: String, imageUrl: String) {
        self.name = name
        self.imageUrl = imageUrl
    }
}
