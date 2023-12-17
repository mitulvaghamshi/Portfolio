package me.mitul.portfolio.android.cards

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.mitul.portfolio.android.R
import me.mitul.portfolio.android.common.Frame
import me.mitul.portfolio.android.common.FrameLink
import me.mitul.portfolio.android.theme.AppTheme
import me.mitul.portfolio.shared.Common

@Composable
internal fun ProfileCard(modifier: Modifier = Modifier) = LazyColumn(
    state = rememberLazyListState(),
    modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
) {
    item { ProfilePicture() }
    item { FullName() }
    item { SocialButtons() }
    item { Description() }
    item {
        val link = Common.externalLinks.last()
        FrameLink(link = link, leading = {
            Image(
                painter = painterResource(id = R.drawable.icon192),
                contentDescription = link.first,
            )
        })
    }
}

@Composable
private fun ProfilePicture(modifier: Modifier = Modifier) = Image(
    painter = painterResource(id = R.drawable.me),
    contentDescription = stringResource(R.string.profile_picture),
    modifier = modifier
        .padding(vertical = 8.dp)
        .clip(shape = RoundedCornerShape(size = 8.dp)),
)

@Composable
private fun FullName(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(vertical = 8.dp)) {
        Text(
            text = stringResource(R.string.software_developer),
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
        )
        Text(
            text = stringResource(R.string.mitul_vaghamshi_),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
        )
    }
}

@Composable
private fun Description(modifier: Modifier = Modifier) = Frame {
    Text(
        text = Common.DESCRIPTION,
        fontSize = 14.sp,
        modifier = modifier.padding(all = 16.dp),
    )
}

@Composable
private fun SocialButtons(modifier: Modifier = Modifier) = Frame {
    val context = LocalContext.current
    val onClick: (String) -> Unit = { link ->
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        context.startActivity(intent)
    }
    Row(
        modifier = modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Common.socialLinks.forEach { link ->
            IconButton(onClick = { onClick(link.third) }) {
                Icon(
                    painter = painterResource(id = socialIcons[link.first]!!),
                    contentDescription = link.second,
                    modifier = Modifier.size(30.dp),
                )
            }
        }
    }
}

private val socialIcons = mapOf(
    Pair(first = 0, second = R.drawable.gmail),
    Pair(first = 1, second = R.drawable.github),
    Pair(first = 2, second = R.drawable.linkedin),
    Pair(first = 3, second = R.drawable.whatsapp),
    Pair(first = 4, second = R.drawable.phone),
)

@Preview(showBackground = true, wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Composable
private fun ProfilePicture_Preview() = AppTheme {
    Surface { ProfilePicture() }
}

@Preview(showBackground = true, wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Composable
private fun FullName_Preview() = AppTheme {
    Surface { FullName() }
}

@Preview(showBackground = true, wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE)
@Composable
private fun SocialButtons_Preview() = AppTheme {
    Surface { SocialButtons() }
}

@Preview(showBackground = true, wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Composable
private fun Description_Preview() = AppTheme {
    Surface { Description() }
}

@Preview(showBackground = true, wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE)
@Composable
private fun FrameLink_Preview() = AppTheme {
    Surface { FrameLink(link = Common.externalLinks.first()) }
}

@Preview(showBackground = true, wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Composable
private fun ProfileCard_Preview() = AppTheme {
    Surface { ProfileCard() }
}
