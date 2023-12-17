//
//  ViewModel.swift
//  Portfolio
//
//  Created by Mitul Vaghamshi on 2023-06-12.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import Shared

@MainActor
class ViewModel: ObservableObject {
    @Published var state: Snapshot = .Loading
    private let sdk: GitHubSdk

    init(_ sdk: GitHubSdk) {
        self.sdk = sdk
        loadRepos()
    }
}

extension ViewModel {
    enum Snapshot {
        case Loading
        case Error(String)
        case Data([GitHubRepo])
    }
}

extension ViewModel {
    func loadRepos(cache: Bool = true) {
        self.state = .Loading

        DispatchQueue.main.async { [weak self] in
            self?.sdk.getRepos(limit: 30, cached: cache) { repos, error in
                if let repos = repos {
                    self?.state = .Data(repos)
                } else {
                    self?.state = .Error(
                        error?.localizedDescription
                        ?? "Error loading github repos..."
                    )
                }
            }
        }
    }
}
