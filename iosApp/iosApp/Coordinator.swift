//
//  Coordinator.swift
//  iosApp
//
//  Created by Marco Antonio Martinez Gutierrez on 08/05/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


enum FullScreenCover: String, Identifiable {
    case loader
    
    var id: String {
        self.rawValue
    }
}

enum Page:String, Identifiable {
    case search
    case homeList
    
    var id: String {
        self.rawValue
    }
}


class Coordinator: ObservableObject {
    
    @Published var path: NavigationPath = NavigationPath()
    @Published var page: Page?
    @Published var fullScreenCover: FullScreenCover?
    private var location: Location?
    
    func push(_ page: Page){
        path.append(page)
    }
    
    func present(_ fullScreenCover:FullScreenCover){
        self.fullScreenCover = fullScreenCover
    }
    
    func pop(){
        path.removeLast()
    }
    
    func dismissFullScreenCover(){
        self.fullScreenCover = nil
    }
    
    func setLocation(_ location: Location){
        self.location = location
    }
    
    @ViewBuilder
    func build(page: Page) -> some View {
        switch page {
        case .search:
            SearchView()
        case .homeList:
            HomesListView(location: location!)
        }
    }
    
    @ViewBuilder
    func build(fullScreenCover: FullScreenCover)-> some View {
        /*switch overlay {
            case .loader:
            //LoaderView()
        }*/
        
    }
}

