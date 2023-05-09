//
//  CoordinatorView.swift
//  iosApp
//
//  Created by Marco Antonio Martinez Gutierrez on 08/05/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct CoordinatorView: View {
    
    @StateObject private var coordinator = Coordinator()
    
    var body: some View {
        NavigationStack(path: $coordinator.path) {
            coordinator.build(page: .search)
                .navigationDestination(for: Page.self){ page in
                    coordinator.build(page: page)
                }
                .fullScreenCover(item: $coordinator.fullScreenCover){ fullScreenCover in
                    coordinator.build(fullScreenCover: fullScreenCover)
                }
        }
        .environmentObject(coordinator)
    }
}


struct CoordinatorView_Previews: PreviewProvider {
    static var previews: some View {
        CoordinatorView()
    }
}
