//
//  HomesListView.swift
//  iosApp
//
//  Created by Marco Antonio Martinez Gutierrez on 08/05/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomesListView: View {
    
    @EnvironmentObject private var coordinator: Coordinator
    @ObservedObject var viewModel: HomesListViewModel
    
    init(location: Location) {
        self.viewModel = HomesListViewModel(location: location)
    }
    
    var body: some View {
        
        VStack{
            ScrollView{
                ForEach(viewModel.homesList, id: \.self){ home in
                    VStack(alignment: .center){
                        AsyncImage(url: URL(string: home.imgSrc ?? "")){ image in
                            image.resizable().scaledToFill().clipped().frame(height: 160, alignment: .center)
                        }placeholder: {
                            Color.gray
                        }.frame(height: 160)
                        VStack(alignment: .leading){
                            Text(home.price ?? "$0+").font(.title2).fontWeight(.bold)
                            Text("\(home.beds ?? 0) beds \(home.baths ?? 0.0) baths - \(home.statusText ?? "")").font(.caption)
                            Text(home.address ?? "").font(.caption)
                            Text(home.brokerName ?? "").font(.caption).foregroundColor(.gray)
                            
                        }.frame(maxWidth: .infinity).background(Color.white)
                        
                    }.clipShape(RoundedRectangle(cornerRadius: 8)).frame(height: 260)
                }
            }.padding(8)
            
        }.onAppear(){
            Task{
                await viewModel.loadList()
            }
        }.toolbar {
            ToolbarItem(placement: .principal) {
                Image("z-logo-default")
            }
        }.frame(maxWidth: .infinity, maxHeight: .infinity).background(Color(red:0.94, green: 0.94, blue: 0.96))
    }
    
}

/*
struct HomesListView_Previews: PreviewProvider {
    static var previews: some View {
        //HomesListView()
    }
}
*/
