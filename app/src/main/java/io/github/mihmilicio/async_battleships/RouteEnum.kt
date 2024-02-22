package io.github.mihmilicio.async_battleships

import androidx.annotation.StringRes
import io.github.mihmilicio.async_battleships.R

enum class RouteEnum(@StringRes val title: Int) {
    Login(title = R.string.login_title),
    Signup(title = R.string.signup_title);

    companion object {
        val START_ROUTE = Login
    }
}



