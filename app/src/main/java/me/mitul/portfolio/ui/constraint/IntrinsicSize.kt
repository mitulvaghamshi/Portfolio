package me.mitul.portfolio.ui.constraint

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun IntrinsicSize() {
    Row(Modifier.height(IntrinsicSize.Min)) {
        Text(
            "Hello",
            Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .wrapContentWidth(Alignment.Start)
        )
        Divider(
            Modifier
                .fillMaxHeight()
                .width(1.dp),
            Color.Black
        )
        Text(
            "World",
            Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End),
        )
    }
}
