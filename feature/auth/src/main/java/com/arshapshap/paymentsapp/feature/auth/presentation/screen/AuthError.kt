package com.arshapshap.paymentsapp.feature.auth.presentation.screen

import com.arshapshap.paymentsapp.core.presentation.BaseError

internal interface AuthError : BaseError {

    data class EmptyLogin(val actual: Boolean = true) : AuthError

    data class EmptyPassword(val actual: Boolean = true) : AuthError

    data class IncorrectCredentials(val actual: Boolean = true) : AuthError
}