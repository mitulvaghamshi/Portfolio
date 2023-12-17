import SwiftUI
import Shared

struct ContentView: View {
    @ObservedObject private(set) var model: ViewModel
    @State private var selection: Tab = .Profile

    var body: some View {
        TabView(selection: $selection) {
            IntroCard()
                .tag(Tab.Profile)
                .tabItem { Label(Tab.Profile.id, systemImage: "person") }
            EduCard()
                .tag(Tab.Education)
                .tabItem { Label(Tab.Education.id, systemImage: "graduationcap") }
            RepoCard(state: model.state, refresh: { model.loadRepos(cache: false) })
                .tag(Tab.Repository)
                .tabItem { Label(Tab.Repository.id, systemImage: "chevron.left.forwardslash.chevron.right") }
        }
    }
}

extension ContentView {
    enum Tab: String, Hashable, Identifiable, CaseIterable {
        case Profile
        case Education
        case Repository

        var id: String { rawValue }
    }
}

#Preview {
    let sdk = GitHubSdk(factory: DbDriverFactory())
    return ContentView(model: .init(sdk))
}
