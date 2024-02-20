package com.example.async_battleships.ui.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.async_battleships.ui.theme.AsyncBattleshipsTheme

/**
 * Composable that allows the user to enter username and password ans expects
 * [onLoginSuccessful] lambda that  triggers the navigation to next screen
 */
@Composable
fun LoginScreen(
    onLoginSuccessful: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login works!",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


@Preview
@Composable
fun LoginPreview() {
    AsyncBattleshipsTheme {
        LoginScreen(
            onLoginSuccessful = {},
            modifier = Modifier
                .fillMaxSize()
        )
    }
}