package io.github.mihmilicio.async_battleships.ui.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.mihmilicio.async_battleships.R
import io.github.mihmilicio.async_battleships.ui.common.EmailField
import io.github.mihmilicio.async_battleships.ui.common.PasswordField
import io.github.mihmilicio.async_battleships.ui.common.PrimaryButton
import io.github.mihmilicio.async_battleships.ui.theme.AsyncBattleshipsTheme

/**
 * Composable that allows the user to enter username and password ans expects
 * [redirectToHomeScreen] lambda that  triggers the navigation to next screen
 */
@Composable
fun LoginScreen(
    redirectToHomeScreen: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val currentRedirectToHomeScreen by rememberUpdatedState(redirectToHomeScreen)

    LaunchedEffect(viewModel.uiState) {
        if (viewModel.uiState.isUserLoggedIn) {
            currentRedirectToHomeScreen()
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.screen_padding)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailField(value = viewModel.uiState.email, onValueChange = viewModel::onEmailChange)
            Spacer(modifier = Modifier.size(dimensionResource(R.dimen.space_between_fields)))
            // TODO IME
            PasswordField(value = viewModel.uiState.password, onValueChange = viewModel::onPasswordChange)
            Spacer(modifier = Modifier.size(dimensionResource(R.dimen.space_before_button)))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                PrimaryButton(
                    text = R.string.login_button,
                    action = { viewModel.onLoginClick() },
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}


@Preview
@Composable
fun LoginPreview() {
    AsyncBattleshipsTheme {
        LoginScreen(
            redirectToHomeScreen = {},
            modifier = Modifier
                .fillMaxSize()
        )
    }
}