//
//  HomesListViewModel.swift
//  iosApp
//
//  Created by Marco Antonio Martinez Gutierrez on 08/05/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension HomesListView{
    @MainActor class HomesListViewModel: ObservableObject{
        
        @Published private(set) var homesList: [Home] = []
        private var location : Location
        private let getHomeListUserCase = GetHomeListUseCase.init()
        
        init(location: Location) {
            self.location = location
        }
        
        func loadList() async {
            do{
                let homes = try await getHomeListUserCase.invoke(location: location)
                self.homesList = homes
            }catch{
                
            }
        }
        
        
    }
    
}
