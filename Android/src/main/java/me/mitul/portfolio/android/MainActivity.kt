package me.mitul.portfolio.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import me.mitul.portfolio.android.cards.CertificateCard
import me.mitul.portfolio.android.cards.EducationCard
import me.mitul.portfolio.android.cards.GitHubRepoCard
import me.mitul.portfolio.android.cards.ProfileCard
import me.mitul.portfolio.android.common.AppScaffold
import me.mitul.portfolio.android.common.SplashScreen
import me.mitul.portfolio.android.models.RepoViewModel
import me.mitul.portfolio.android.theme.AppTheme
import me.mitul.portfolio.android.theme.GreenColorScheme
import me.mitul.portfolio.cache.DbDriverFactory
import me.mitul.portfolio.github.GitHubSdk

class MainActivity : ComponentActivity() {
    private val sdk = GitHubSdk(DbDriverFactory(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val model by remember {
                derivedStateOf { RepoViewModel(sdk) }
            }
            AppTheme(colorScheme = GreenColorScheme) {
                SplashScreen { PortfolioApp(model = model) }
            }
        }
    }
}

@Composable
private fun PortfolioApp(
    modifier: Modifier = Modifier,
    model: RepoViewModel
) = AppScaffold(modifier = modifier) { tabIndex ->
    when (tabIndex) {
        0 -> ProfileCard()
        1 -> EducationCard()
        2 -> GitHubRepoCard(model = model)
        3 -> CertificateCard()
        else -> SplashScreen { // Should never reach
            Log.e(
                stringResource(R.string.portfolioapp),
                stringResource(R.string.error_invalid_tab_index)
            )
            Text(text = stringResource(id = R.string.error_invalid_tab_index))
        }
    }
}
