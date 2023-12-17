package me.mitul.portfolio.android.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import me.mitul.portfolio.android.R
import me.mitul.portfolio.android.theme.AppTheme

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    visible: Boolean = true,
    content: @Composable () -> Unit
) {
    var isVisible by rememberSaveable { mutableStateOf(value = visible) }
    if (!isVisible) {
        content()
    } else {
        Surface(modifier = modifier) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AppLogo()
                ContinueButton { isVisible = false }
            }
        }
    }
}

@Composable
fun AppLogo(modifier: Modifier = Modifier) {
    val infiniteTransition =
        rememberInfiniteTransition(label = stringResource(id = R.string.transition))
    val angle by infiniteTransition.animateFloat(
        label = stringResource(id = R.string.animation),
        initialValue = 0.0f,
        targetValue = 360.0f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Reverse,
            animation = keyframes { durationMillis = 10_000 },
        )
    )
    Image(
        painter = painterResource(id = R.drawable.icon192),
        contentDescription = stringResource(id = R.string.app_logo),
        modifier = modifier
            .aspectRatio(ratio = 1.0f)
            .padding(all = 50.dp)
            .rotate(degrees = angle)
    )
}

@Composable
fun ContinueButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val localOnClick by rememberUpdatedState(newValue = onClick)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(localOnClick) {
            Text(text = stringResource(id = R.string.btnContinue))
        }
    }
    LaunchedEffect(key1 = Unit) {
        delay(timeMillis = 10_000)
        localOnClick()
    }
}

@Preview(showBackground = true, wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Composable
private fun SplashScreen_Preview() = AppTheme {
    SplashScreen {}
}
