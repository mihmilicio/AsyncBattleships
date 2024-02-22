package io.github.mihmilicio.async_battleships.domain.usecase.login

import com.google.firebase.auth.FirebaseUser
import io.github.mihmilicio.async_battleships.data.repository.AuthRepository
import javax.inject.Inject

class AuthenticateWithPasswordUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    // TODO custom user model and exceptions
    operator fun invoke(
        email: String,
        password: String,
        onSuccess: (FirebaseUser?) -> Unit = {},
        onError: (Exception) -> Unit = {}
    ) = authRepository.authenticateWithPassword(email, password, onSuccess, onError)

}