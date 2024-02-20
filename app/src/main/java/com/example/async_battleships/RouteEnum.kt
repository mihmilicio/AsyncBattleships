package com.example.async_battleships

import androidx.annotation.StringRes

enum class RouteEnum(@StringRes val title: Int) {
    Login(title = R.string.login_title),
    Signup(title = R.string.signup_title);

    companion object {
        val START_ROUTE = Login
    }
}



