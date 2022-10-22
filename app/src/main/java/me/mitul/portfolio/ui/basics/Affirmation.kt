package me.mitul.portfolio.ui.basics

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.mitul.portfolio.data.Affirmation
import me.mitul.portfolio.data.SampleData.affirmations

@Composable
fun Affirmation() {
    val scrollState = rememberLazyListState()
    val list = remember { mutableStateListOf(*affirmations) }
    LazyColumn(state = scrollState, horizontalAlignment = Alignment.CenterHorizontally) {
        items(list) { item -> AffirmationCard(item) }
    }
}

@Composable
private fun AffirmationCard(affirmation: Affirmation) {
    var expanded by rememberSaveable { mutableStateOf(false) }
//  val image = rememberAsyncImagePainter(SampleData.robotUrl)
    Card(
        Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .animateContentSize()
            .clickable { expanded = !expanded }, elevation = 2.dp
    ) {
        Column {
            val string = stringResource(affirmation.text)
            Text(
                text = string,
                maxLines = if (expanded) 3 else 1,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            )
            if (expanded) {
                Image(
                    painter = painterResource(affirmation.image),
                    contentDescription = string,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth(),
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewAffirmationCard() {
    AffirmationCard(affirmations.first())
}
