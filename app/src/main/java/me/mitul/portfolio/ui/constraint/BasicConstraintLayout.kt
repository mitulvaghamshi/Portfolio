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
private fun BasicConstraintLayout() {
    ConstraintLayout {
        val (button, text) = createRefs()
        Button({}, Modifier.constrainAs(button) {
            top.linkTo(parent.top, margin = 10.dp)
        }) { Text("Button") }
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}
