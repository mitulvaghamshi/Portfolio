package me.mitul.portfolio.ui.constraint

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun MeasuredLayout() {
    Layout({
        Text("One")
        Text("Two")
        Text("Three")
    }, Modifier.wrapContentHeight()) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }
        var yPosition = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach {
                it.placeRelative(0, yPosition)
                yPosition += it.height
            }
        }
    }
}
