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
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import me.mitul.portfolio.shared.NavTab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AppScaffold(modifier: Modifier = Modifier, content: @Composable (NavTab) -> Unit) {
    val behavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val (tab, setTab) = remember { mutableStateOf(value = NavTab.Hello) }
    Scaffold(
        modifier = Modifier.nestedScroll(behavior.nestedScrollConnection),
        topBar = { TopAppBar(behavior = behavior, tab = tab) },
        bottomBar = { NavigationBar(tab = tab, onChange = setTab) }
    ) {
        Surface(modifier = modifier.padding(paddingValues = it)) { content(tab) }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar(behavior: TopAppBarScrollBehavior, tab: NavTab) = LargeTopAppBar(
    title = {
        Text(
            text = tab.name, overflow = TextOverflow.Ellipsis,
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold, maxLines = 1,
        )
    }, scrollBehavior = behavior
)

@Composable
private fun NavigationBar(tab: NavTab, onChange: (NavTab) -> Unit) = NavigationBar {
    NavTab.entries.forEach {
        NavigationBarItem(
            icon = { Icon(it.icon, it.name) },
            label = { Text(it.name) },
            selected = tab == it,
            onClick = { onChange(it) },
        )
    }
}

@Preview
@Composable
private fun AppScaffold_Preview() = AppScaffold {}

private val NavTab.icon: ImageVector
    get() = when (this) {
        NavTab.Hello -> Icons.Default.AccountCircle
        NavTab.Education -> Icons.Default.School
        NavTab.Repos -> Icons.Default.Code
        NavTab.More -> Icons.AutoMirrored.Filled.Segment
    }
