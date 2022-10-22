package me.mitul.portfolio.ui.basics

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.mitul.portfolio.R

@Preview
@Composable
fun DiceRoller() {
    var expanded by remember { mutableStateOf(false) }
    DiceRoller(expanded) { expanded = !expanded }
}

@Composable
private fun DiceRoller(expanded: Boolean, onClick: () -> Unit) {
    Card(Modifier.padding(8.dp)) {
        Column(
            Modifier
                .animateContentSize()
                .padding(8.dp)
        ) {
            Text("Dice Roller", style = MaterialTheme.typography.h6)
            if (expanded) {
                DiceView()
                IconButton(onClick, Modifier.fillMaxWidth()) {
                    Icon(Icons.Default.ExpandLess, stringResource(R.string.cd_collapse))
                }
            } else {
                IconButton(onClick, Modifier.fillMaxWidth()) {
                    Icon(Icons.Default.ExpandMore, stringResource(R.string.cd_expand))
                }
            }
        }
    }
}

@Preview
@Composable
private fun DiceView() {
    @DrawableRes var dice by remember { mutableStateOf(R.drawable.dice_1) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(dice), dice.toString())
        Spacer(Modifier.height(20.dp))
        Button({ dice = roll() }) { Text("Roll the Dice!") }
    }
}

private fun roll() = when ((1..6).random()) {
    1 -> R.drawable.dice_1
    2 -> R.drawable.dice_2
    3 -> R.drawable.dice_3
    4 -> R.drawable.dice_4
    5 -> R.drawable.dice_5
    else -> R.drawable.dice_6
}
