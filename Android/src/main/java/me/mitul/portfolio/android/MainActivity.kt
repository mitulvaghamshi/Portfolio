package me.mitul.portfolio.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import me.mitul.portfolio.android.cards.EduCard
import me.mitul.portfolio.android.cards.ExtraCard
import me.mitul.portfolio.android.cards.MeCard
import me.mitul.portfolio.android.cards.RepoCard
import me.mitul.portfolio.android.common.AppScaffold
import me.mitul.portfolio.android.common.SplashScreen
import me.mitul.portfolio.android.model.RepoModel
import me.mitul.portfolio.android.theme.AppTheme
import me.mitul.portfolio.cache.DriverFactory
import me.mitul.portfolio.github.GitHubSdk
import me.mitul.portfolio.shared.NavTab

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val model by remember {
                val factory = DriverFactory(context = applicationContext)
                val sdk = GitHubSdk(factory = factory)
                derivedStateOf { RepoModel(sdk = sdk) }
            }
            AppTheme {
                SplashScreen {
                    PortfolioApp(model = model)
                }
            }
        }
    }
}

@Composable
private fun PortfolioApp(
    modifier: Modifier = Modifier, model: RepoModel = viewModel(),
) = AppScaffold(modifier = modifier) {
    when (it) {
        NavTab.Hello -> MeCard()
        NavTab.Education -> EduCard()
        NavTab.Repos -> RepoCard(model = model)
        NavTab.More -> ExtraCard()
    }
}
