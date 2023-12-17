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
import me.mitul.portfolio.android.R
import me.mitul.portfolio.shared.ExternalLink

@Composable
internal fun FrameLink(
    modifier: Modifier = Modifier,
    link: ExternalLink,
    leading: (@Composable () -> Unit)? = null,
) = Frame(modifier = modifier, url = link.url) {
    ListItem(
        colors = ListItemDefaults
            .colors(containerColor = MaterialTheme.colorScheme.surface),
        leadingContent = { leading?.invoke() },
        headlineContent = { Text(text = link.title, fontWeight = FontWeight.Bold) },
        overlineContent = {
            Text(
                text = link.url, color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis, maxLines = 1,
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

@Preview
@Composable
private fun FrameLink_Preview() = FrameLink(link = ExternalLink.Privacy)
