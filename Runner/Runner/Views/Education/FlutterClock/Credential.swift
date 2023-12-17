//
//  ClockPass.swift
//  Runner
//
//  Created by Mitul Vaghamshi on 2023-07-06.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI

struct Credential: View {
    var body: some View {
        List {
            VStack(alignment: .leading) {
                HStack(spacing: 16) {
                    Image("Flutter Logo")
                        .resizable()
                        .frame(width: 60, height: 60)
                    Text("Flutter")
                        .font(.title)
                        .passText()
                }
                Spacer(minLength: 16)
                HStack(alignment: .top) {
                    VStack(alignment: .leading) {
                        Text("CREDENTIAL").passLabel()
                        Text("Flutter Clock").passText().bold()
                        Spacer()
                        Text("OWNER NAME").passLabel()
                        Text("Mitul Vaghamshi").passText()
                        Spacer()
                        Text("ISSUED ON").passLabel()
                        Text("2020-01-20").passText()
                    }
                    Spacer()
                    VStack(alignment: .trailing) {
                        Image("Clock Badge")
                            .resizable()
                            .aspectRatio(1, contentMode: .fit)
                            .frame(width: 130)
                        Spacer()
                        Text("CREDENTIAL ID").passLabel()
                        Text("bhlz2ezh").passText()
                    }
                }
                Image("Certificate Link QR")
                    .resizable()
                    .aspectRatio(1, contentMode: .fit)
                    .frame(width: 200)
            }
            .padding()
            .background(Color("Pass Background"))
            .cornerRadius(8)
        }
        .listStyle(.plain)
        .navigationTitle("Credential")
    }
}

private struct GreenTitle3: ViewModifier {
    func body(content: Content) -> some View {
        content
            .font(.title3)
            .foregroundStyle(Color("Pass Label"))
    }
}

private struct WhiteTitle2: ViewModifier {
    func body(content: Content) -> some View {
        content
            .font(.title2)
            .foregroundStyle(.white)
    }
}

private extension Text {
    func passLabel() -> some View { modifier(GreenTitle3()) }

    func passText() -> some View { modifier(WhiteTitle2()) }
}

#Preview {
    NavigationView { Credential() }
}
