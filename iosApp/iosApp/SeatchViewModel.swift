//
//  SeatchViewModel.swift
//  iosApp
//
//  Created by Marco Antonio Martinez Gutierrez on 07/05/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension SearchView {
    @MainActor class SearchViewModel: ObservableObject {
        
        @Published private(set) var locations: [Location] = []
        @Published private(set) var isLoading: Bool = false
        
        private let getLocationUseCase = GetLocationUseCase.init()
        
        func queryLocation(_ query:String) async {
            
            do{
                let locations = try await getLocationUseCase.invoke(query: query)
                self.locations = locations
            }catch{
                
            }
        }
        
    }
    
}
