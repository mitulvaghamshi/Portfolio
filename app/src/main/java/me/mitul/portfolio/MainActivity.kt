package me.mitul.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import me.mitul.portfolio.ui.AppTheme
import me.mitul.portfolio.ui.basics.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                ConsentScreen {
                    Column {
                        StaggeredGridView()
                        DiceRoller()
                        Affirmation()
                    }
                }
            }
        }
    }
}
