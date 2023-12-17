import SwiftUI
import Shared

struct ContentView: View {
    @ObservedObject private(set) var model: ViewModel = .init()

    @State private var selection: NavTab = .hello

    var body: some View {
        TabView(selection: $selection) {
            IntroCard()
                .tag(NavTab.hello)
                .tabItem { IntroLabel }
            
            EduCard()
                .tag(NavTab.education)
                .tabItem { EduLabel }
            
            RepoCard(state: model.state, onLoad: model.loadRepos)
                .tag(NavTab.repos)
                .tabItem { RepoLabel }
        }
    }
}

extension ContentView {
    @ViewBuilder var IntroLabel: some View {
        Label(NavTab.hello.name, systemImage: "person")
    }

    @ViewBuilder var EduLabel: some View {
        Label(NavTab.education.name, systemImage: "graduationcap")
    }

    @ViewBuilder var RepoLabel: some View {
        Label(NavTab.repos.name, systemImage: "chevron.left.forwardslash.chevron.right")
    }
}

#Preview { ContentView() }
