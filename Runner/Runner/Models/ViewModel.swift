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
    @Published var state: State = .Loading

    private let sdk: GitHubSdk

    init(_ sdk: GitHubSdk) {
        self.sdk = sdk
    }

    init() {
        let factory = DriverFactory()
        self.sdk = GitHubSdk(factory: factory)
    }
}

extension ViewModel {
    enum State {
        case Loading
        case Error(String)
        case Data([GitHubRepo])
    }
}

extension ViewModel {
    func loadRepos(cache: Bool) {
        self.state = .Loading

        Task {
            {sdk.getRepos(limit: 30, cached: cache) { repos, error in
                if let repos = repos {
                    self.state = .Data(repos)
                } else {
                    self.state = .Error(
                        error?.localizedDescription
                        ?? "Error loading github repos..."
                    )
                }
            }}()
        }
    }
}
