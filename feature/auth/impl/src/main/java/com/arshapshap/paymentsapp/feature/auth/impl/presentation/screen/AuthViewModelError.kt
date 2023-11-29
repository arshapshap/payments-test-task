package com.arshapshap.paymentsapp.feature.auth.impl.presentation.screen

import com.arshapshap.paymentsapp.core.presentation.BaseError

internal interface AuthViewModelError : BaseError {

    data class EmptyLogin(val actual: Boolean = true) : AuthViewModelError

    data class EmptyPassword(val actual: Boolean = true) : AuthViewModelError

    data class IncorrectCredentials(val actual: Boolean = true) : AuthViewModelError
}