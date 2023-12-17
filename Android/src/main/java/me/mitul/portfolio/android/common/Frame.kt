package me.mitul.portfolio.android.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import me.mitul.portfolio.android.theme.AppTheme

@Composable
internal fun Frame(
    modifier: Modifier = Modifier,
    url: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val context = LocalContext.current
    val onClick = {
        if (url != null) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
    }
    Card(
        modifier = modifier.padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        onClick = onClick,
        content = content,
    )
}

@Preview(showBackground = true, wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE)
@Composable
private fun FrameCard_Preview() = AppTheme {
    Box(modifier = Modifier.padding(16.dp)) {
        Frame {
            Text(
                text = "Hello World!",
                modifier = Modifier.padding(all = 16.dp),
            )
        }
    }
}
