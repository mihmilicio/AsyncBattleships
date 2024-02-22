package io.github.mihmilicio.async_battleships.data.repository

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import javax.inject.Inject

class AuthRepository @Inject constructor() {

    fun authenticateWithPassword(
        email: String,
        password: String,
        onSuccess: (FirebaseUser?) -> Unit = {},
        onError: (Exception) -> Unit = {}
    ) {
        // TODO inject firebase auth
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { onSuccess(it.user) }
            .addOnFailureListener { onError(it) }
    }

}