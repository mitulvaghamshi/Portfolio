//
//  RepoDetails.swift
//  Portfolio
//
//  Created by Mitul Vaghamshi on 2023-06-12.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI
import Shared

struct RepoDetails: View {
    let repo: GitHubRepo
    
    var body: some View {
        List {
            Section(header: Text("Repository")) {
                Label(repo.name, image: "GitHub")
                    .font(.headline)
                if let language = repo.language {
                    Label(language, systemImage: "chevron.left.forwardslash.chevron.right")
                }
                Label(repo.size.toMemory(), systemImage: "folder")
            }
            if let description = repo.description_ {
                Section(header: Text("Description")) {
                    Text(description)
                }
            }
            if !repo.topics.isEmpty {
                Section(header: Text("Repository Topics")) {
                    ForEach(repo.topics, id: \.self) { topic in
                        Label(topic, systemImage: "star")
                    }
                }
            }
            Section(header: Text("GitHub Link")) {
                Link(destination: URL(string: repo.url)!) {
                    Label(repo.url, systemImage: "link")
                        .font(.callout)
                }
            }
        }
        .navigationTitle("Details")
    }
}

extension Int32 {
    func toMemory() -> String {
        if (self / 1024 > 0) {
            return "\(self / 1024).\(self % 1024 / 10) MB"
        } else {
            return "\(self) KB"
        }
    }
}

#Preview {
    NavigationView { RepoDetails(repo: Common.shared.sampleRepo) }
}
