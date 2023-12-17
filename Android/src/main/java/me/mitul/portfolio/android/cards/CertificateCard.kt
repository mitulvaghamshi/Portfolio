package me.mitul.portfolio.android.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
internal fun CertificateCard(modifier: Modifier = Modifier) = LazyColumn(
    state = rememberLazyListState(),
    modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
) {
    item { Credential() }
    item { Certificate(link = Common.credentialLink) }
    items(items = Common.externalLinks.dropLast(1)) { link ->
        FrameLink(link = link)
    }
}

@Composable
private fun Certificate(
    modifier: Modifier = Modifier,
    link: Pair<String, String>
) = Frame(modifier = modifier, url = link.second) {
    Image(
        painter = painterResource(id = R.drawable.clock_certificate),
        contentDescription = "Flutter Clock Certificate",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth(),
    )
    ListItem(
        colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surface),
        overlineContent = {
            Text(
                text = link.second,
                color = MaterialTheme.colorScheme.tertiary,
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
        supportingContent = {
            Text(text = stringResource(id = R.string.certificate_for_flutter_clock_desc))
        },
        trailingContent = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                contentDescription = stringResource(id = R.string.open_in_browser),
            )
        }
    )
}

@Composable
private fun Credential(modifier: Modifier = Modifier) = Card(
    modifier = modifier.padding(vertical = 8.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
    colors = CardDefaults.cardColors(containerColor = Color(color = 0xFF124347)),
) {
    Row(
        modifier = Modifier.padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.flutter120),
            contentDescription = stringResource(id = R.string.official_flutter_logo),
            modifier = Modifier.size(size = 40.dp),
        )
        Spacer(modifier = Modifier.width(width = 10.dp))
        Text(
            text = stringResource(id = R.string.flutter),
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
    Row(
        modifier = Modifier.padding(all = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        val labelColor = Color(color = 0xFF26C3A2)
        val textColor = Color(color = 0xFFFFFFFF)
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = stringResource(R.string.credential), color = labelColor)
            Text(text = stringResource(R.string.flutter_clock), fontSize = 26.sp, color = textColor)
            Spacer(modifier = Modifier.height(height = 30.dp))
            Text(text = stringResource(R.string.owner_name), color = labelColor)
            Text(text = stringResource(R.string.mitul_vaghamshi), color = textColor)
            Spacer(modifier = Modifier.height(height = 20.dp))
            Text(text = stringResource(R.string.issued_on), color = labelColor)
            Text(text = stringResource(R.string._2020_01_20), color = textColor)
        }
        Spacer(modifier = Modifier.weight(weight = 1f))
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = R.drawable.clock320),
                contentDescription = stringResource(R.string.flutter_clock_challenge_logo),
                modifier = Modifier.size(size = 120.dp),
            )
            Spacer(modifier = Modifier.height(height = 30.dp))
            Text(text = stringResource(R.string.credential_id), color = labelColor)
            Text(text = stringResource(R.string.bhlz2ezh), color = textColor)
        }
    }
    Image(
        painter = painterResource(id = R.drawable.cert_qr),
        contentDescription = stringResource(R.string.flutter_clock_credential_qr_code),
        modifier = Modifier.padding(all = 16.dp),
    )
}

@Preview(showBackground = true, wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE)
@Composable
private fun CertificateCard_Preview() = AppTheme {
    CertificateCard()
}
