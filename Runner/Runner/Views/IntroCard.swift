//
//  IntroCard.swift
//  Runner
//
//  Created by Mitul Vaghamshi on 2023-06-15.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI
import Shared

struct IntroCard: View {
    private let links = Common.shared.externalLinks
    
    var body: some View {
        NavigationView {
            List {
                Image("Me")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .cornerRadius(8)
                    .padding(.top, 10)
                VStack(alignment: .leading, spacing: 8) {
                    Text("Software Developer")
                        .opacity(0.5)
                    Text("Mitul Vaghamshi_")
                        .font(.largeTitle)
                }
                .bold()
                Section("Social Connect") {
                    HStack(alignment: .center) {
                        ForEach(Common.shared.socialLinks, id: \.first) { link in
                            Link(destination: URL(string: "\(link.third!)")!) {
                                Image("\(link.second!)")
                                    .resizable()
                                    .aspectRatio(1, contentMode: .fit)
                                    .padding(8)
                            }
                            .buttonStyle(PlainButtonStyle())
                        }
                    }
                }
                Section("Introduction") {
                    Text(Common.shared.DESCRIPTION)
                        .font(.subheadline)
                }
                Section("External Links") {
                    ForEach(links.dropLast(1), id: \.first) { link in
                        Link(destination: URL(string: "\(link.second!)")!) {
                            Label("\(link.first!)", systemImage: "link")
                        }
                    }
                }
                Section("About") {
                    Link(destination: URL(string: "\(links.last!.second!)")!) {
                        HStack(alignment: .center, spacing: 10) {
                            Image("Flutter Dash")
                                .resizable()
                                .frame(width: 60, height: 60)
                            Text("\(links.last!.first!)")
                                .font(.subheadline)
                                .foregroundColor(.primary)
                        }
                    }
                }
            }
            .navigationTitle("Hello There!")
        }
    }
}

#Preview {
    IntroCard()
}
