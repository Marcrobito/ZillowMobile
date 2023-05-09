import SwiftUI
import shared

struct SearchView: View {
    
    @EnvironmentObject private var coordinator: Coordinator
    
    @ObservedObject var viewModel = SearchViewModel()
	
    @State private var query = ""
    
    var body: some View {
        Form{
            Section{
                TextField("Search", text: $query)
                    .onChange(of: query){ val in
                        Task {
                            await viewModel.queryLocation(query)
                        }
                        
                    }
            }
            Section{
                List(viewModel.locations, id: \.self){ location in
                    //Button(
                    HStack{
                        Image("map")
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(width: 24, height: 24)
                        Text(location.name)
                    }.onTapGesture {
                        coordinator.setLocation(location)
                        coordinator.push( .homeList)
                        print(location.city ??  "Hello")
                    }
                    
                }
            }
        }.toolbar {
            ToolbarItem(placement: .principal) {
                Image("z-logo-default")
            }
        }
        
    }
}

struct SearchView_Previews: PreviewProvider {
    static var previews: some View {
        SearchView()
    }
}
