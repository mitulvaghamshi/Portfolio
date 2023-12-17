//
//  RepoCard.swift
//  Runner
//
//  Created by Mitul Vaghamshi on 2023-06-15.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI
import Shared

struct RepoCard: View {
    let state: ViewModel.Snapshot
    let refresh: () -> Void

    var body: some View {
        NavigationView {
            switch state {
                case .Loading:
                    ProgressView()
                case .Error:
                    Image(systemName: "questionmark.circle")
                        .resizable()
                        .frame(width: 200, height: 200)
                        .foregroundStyle(.secondary)
                case .Data(let repos):
                    List(repos) { repo in
                        NavigationLink(destination: RepoDetails(repo: repo)) {
                            Label(repo.name, image: "GitHub")
                        }
                    }
                    .refreshable { refresh() }
                    .navigationTitle("GitHub Repos")
            }
        }
    }
}

extension GitHubRepo: Identifiable {}

#Preview {
    let repos = repeatElement(Common.shared.sampleRepo, count: 10)
        .shuffled()
    return RepoCard(state: .Data(repos)) {}
}
