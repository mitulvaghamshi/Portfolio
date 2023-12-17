import SwiftUI
import Shared

@main
struct PortfolioApp: App {
    let sdk = GitHubSdk(factory: DbDriverFactory())
    
    var body: some Scene {
        WindowGroup {
            ContentView(model: .init(sdk))
        }
    }
}
