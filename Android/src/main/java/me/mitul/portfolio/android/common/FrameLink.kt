package me.mitul.portfolio.android.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import me.mitul.portfolio.android.R
import me.mitul.portfolio.android.theme.AppTheme
import me.mitul.portfolio.shared.Common

@Composable
internal fun FrameLink(
    modifier: Modifier = Modifier,
    link: Pair<String, String>,
    leading: (@Composable () -> Unit)? = null,
) = Frame(modifier = modifier, url = link.second) {
    ListItem(
        colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surface),
        leadingContent = { if (leading != null) leading() },
        overlineContent = {
            Text(
                text = link.second,
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        headlineContent = {
            Text(
                text = link.first,
                fontWeight = FontWeight.Bold,
            )
        },
        trailingContent = {
            if (leading == null) Icon(
                imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                contentDescription = stringResource(R.string.open_in_browser),
            )
        }
    )
}

@Preview(showBackground = true, wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE)
@Composable
private fun LinkItem_Preview() = AppTheme {
    FrameLink(link = Common.externalLinks.last())
}
