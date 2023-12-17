package me.mitul.portfolio.android.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Segment
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import me.mitul.portfolio.android.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AppScaffold(
    modifier: Modifier = Modifier,
    content: @Composable (Int) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var tabIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(
                        text = navItems[tabIndex].second,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                navItems.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.third, item.second) },
                        label = { Text(item.second) },
                        selected = tabIndex == item.first,
                        onClick = { tabIndex = item.first },
                    )
                }
            }
        }
    ) {
        Surface(modifier = modifier.padding(paddingValues = it)) {
            content(tabIndex)
        }
    }
}

private val navItems = listOf(
    Triple(first = 0, second = "Hello There!", third = Icons.Default.AccountCircle),
    Triple(first = 1, second = "Education", third = Icons.Default.School),
    Triple(first = 2, second = "Repos", third = Icons.Default.Code),
    Triple(first = 3, second = "More", third = Icons.AutoMirrored.Filled.Segment),
)

@Preview(showBackground = true, wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Composable
private fun AppScaffold_Preview() = AppTheme {
    AppScaffold {}
}
