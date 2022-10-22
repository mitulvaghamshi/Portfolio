package me.mitul.portfolio.ui.constraint

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
private fun LinkedConstraintLayout() {
    ConstraintLayout {
        val (button1, button2, text) = createRefs()
        Button({}, Modifier.constrainAs(button1) {
            top.linkTo(parent.top, margin = 16.dp)
        }) { Text("Button 1") }
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })
        val barrier = createEndBarrier(button1, text)
        Button({}, Modifier.constrainAs(button2) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(barrier)
        }) { Text("Button 2") }
    }
}
