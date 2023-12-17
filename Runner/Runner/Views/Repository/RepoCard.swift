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
    let state: ViewModel.State
    let onLoad: (_ cache: Bool) -> Void

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
                    List(repos) { repo in BuildRepoItem(repo) }
                        .refreshable { onLoad(false) }
                        .navigationTitle("GitHub Repos")
            }
        }
        .onAppear { onLoad(true) }
    }
}

extension RepoCard {
    @ViewBuilder func BuildRepoItem(_ repo: GitHubRepo) -> some View {
        NavigationLink(destination: RepoDetails(repo: repo)) {
            Label(repo.name, image: "GitHub")
        }
    }
}

extension GitHubRepo: Identifiable {}

#Preview {
    let repo = DataKt.sampleRepo
    let repos = (0...10).map { index in
        GitHubRepo(
            id: index,
            name: repo.name,
            url: repo.url,
            size: repo.size,
            language: repo.language,
            description: repo.description_,
            topics: repo.topics
        )
    }

    return RepoCard(state: .Data(repos)) { _ in }
}
