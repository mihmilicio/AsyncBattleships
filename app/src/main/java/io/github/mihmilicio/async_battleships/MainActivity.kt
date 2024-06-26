package io.github.mihmilicio.async_battleships

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.mihmilicio.async_battleships.ui.theme.AsyncBattleshipsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsyncBattleshipsTheme {
                BattleshipsApp()
            }
        }
    }
}
