//
//  WesDetails.swift
//  Runner
//
//  Created by Mitul Vaghamshi on 2023-07-06.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI
import Shared

struct WesDetails: View {
    var body: some View {
        List {
            Section(header: Text("Varification Badge")) {
                Image("Degree Evaluation Logo")
                    .resizable()
                    .aspectRatio(1, contentMode: .fit)
                HStack {
                    Spacer()
                    Text("Verified International Academic Qualifications")
                        .bold()
                        .font(.title2)
                        .multilineTextAlignment(.center)
                    Spacer()
                }
            }
            ForEach(Common.shared.wesLinks, id: \.first) { link in
                Section(header: Text("\(link.first!)")) {
                    let url = URL(string: "\(link.second!)")!
                    Link(destination: url) {
                        Label("\(url.scheme!)://\(url.host!)", systemImage: "link")
                    }
                }
            }
        }
        .navigationTitle("Degree Evaluation")
    }
}

#Preview {
    NavigationView { WesDetails() }
}
