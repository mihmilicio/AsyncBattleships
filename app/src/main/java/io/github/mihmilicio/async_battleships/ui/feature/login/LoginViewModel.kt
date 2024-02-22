package io.github.mihmilicio.async_battleships.ui.feature.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.mihmilicio.async_battleships.domain.usecase.login.AuthenticateWithPasswordUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticateWithPasswordUseCase: AuthenticateWithPasswordUseCase
) : ViewModel() {

    private val email
        get() = uiState.email
    private val password
        get() = uiState.password

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newValue: String) {
        uiState = uiState.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState = uiState.copy(password = newValue)
    }

    fun onLoginClick() {
        // TODO consider onSuccess/onError or try/catch
        viewModelScope.launch {
            authenticateWithPasswordUseCase(email, password,
                onSuccess = {
                    Log.d("LoginViewModel success", it?.email.toString())
                    uiState = uiState.copy(isUserLoggedIn = true, errorMessage = null)
                }, onError = {
                    Log.d("LoginViewModel error", it.message.toString())
                    uiState = uiState.copy(isUserLoggedIn = false, errorMessage = it.message)
                })

        }
    }
}