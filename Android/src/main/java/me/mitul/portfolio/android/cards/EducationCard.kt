package me.mitul.portfolio.android.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import me.mitul.portfolio.shared.Education

@Composable
internal fun EducationCard(modifier: Modifier = Modifier) = LazyColumn(
    state = rememberLazyListState(),
    modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
) {
    items(Common.educations) { college ->
        EduItem(education = college)
    }
    item { WesEvaluation() }
    items(Common.wesLinks) { link ->
        FrameLink(link = link)
    }
}

@Composable
private fun EduItem(
    modifier: Modifier = Modifier,
    education: Education
) = Frame(modifier = modifier, url = education.url) {
    val icons = eduIcons[education.id]
    Image(
        painter = painterResource(id = icons.second),
        contentScale = ContentScale.FillWidth,
        contentDescription = education.name,
        modifier = Modifier.fillMaxWidth(),
    )
    ListItem(
        colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surface),
        leadingContent = {
            Image(
                painter = painterResource(id = icons.third),
                contentDescription = education.name,
            )
        },
        overlineContent = {
            Text(
                text = education.url,
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        },
        headlineContent = {
            Text(
                text = education.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        supportingContent = {
            Column(modifier = Modifier.padding(top = 8.dp)) {
                Text(
                    text = education.year,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = education.major,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = education.address)
            }
        },
        trailingContent = {
            Text(
                text = education.duration,
                fontWeight = FontWeight.Bold,
            )
        }
    )
}

@Composable
private fun WesEvaluation(modifier: Modifier = Modifier) = Frame(modifier = modifier) {
    Image(
        painter = painterResource(id = R.drawable.wes),
        contentDescription = stringResource(id = R.string.world_education_services_logo),
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 30.dp)
            .aspectRatio(ratio = 1.0f),
    )
    Text(
        text = stringResource(id = R.string.verified_international_academic_qualifications),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
        fontSize = 24.sp,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
    )
}

private val eduIcons = listOf(
    Triple(first = 0, second = R.drawable.mohawk, third = R.drawable.mohawk_logo),
    Triple(first = 1, second = R.drawable.amrut, third = R.drawable.amrut_logo),
)

@Preview(showBackground = true, wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Composable
private fun EducationCard_Preview() = AppTheme {
    EducationCard()
}
