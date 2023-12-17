//
//  LinkItem.swift
//  Runner
//
//  Created by Mitul Vaghamshi on 2024-04-25.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LinkItem: View {
    let url: String
    let title: String?

    init(url: String, title: String? = nil) {
        self.url = url
        self.title = title
    }

    var body: some View {
        if let url = URL(string: url) {
            Link(destination: url) {
                if let title = title {
                    Label(title, systemImage: "link")
                } else {
                    Label("\(url.scheme!)://\(url.host!)", systemImage: "link")
                }
            }
            .font(.callout)
        }
    }
}

#Preview {
    LinkItem(url: "https://support.apple.com/mail", title: "Mail Lookup")
}
