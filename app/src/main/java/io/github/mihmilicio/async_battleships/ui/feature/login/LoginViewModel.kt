package io.github.mihmilicio.async_battleships.ui.feature.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
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
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    var uiState = mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    // TODO review how to pass the redirection
    fun onLoginClick(onSuccess: () -> Unit) {
        // TODO consider onSuccess/onError or try/catch
        viewModelScope.launch {
            authenticateWithPasswordUseCase(email, password,
                onSuccess = {
                    Log.d("LoginViewModel success", it?.email.toString())
                    onSuccess()
                }, onError = {
                    Log.d("LoginViewModel error", it.message.toString())
                })

        }
    }
}