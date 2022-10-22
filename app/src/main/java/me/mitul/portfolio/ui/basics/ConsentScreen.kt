package me.mitul.portfolio.ui.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.mitul.portfolio.R

@Preview
@Composable
fun ConsentScreen(content: @Composable (paddingValues: PaddingValues) -> Unit = {}) {
    var showConsent by rememberSaveable { mutableStateOf(true) }
    if (showConsent) {
        Surface(Modifier.background(MaterialTheme.colors.background)) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                Arrangement.Center,
                Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.mipmap.ic_launcher),
                    contentDescription = "Jetpack Compose Logo",
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape),
                )
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "This app does not collect any of your personal information.",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(20.dp))
                Button({ showConsent = false }) {
                    Text("Continue")
                }
            }
        }
    } else {
        Scaffold(
            content = content,
            topBar = {
                TopAppBar(
                    title = { Text("Affirmations") },
                    actions = {
                        IconButton({ }) {
                            Icon(Icons.Filled.Search, "Favorite Button")
                        }
                    }
                )
            }
        )
    }
}
