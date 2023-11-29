package com.arshapshap.paymentsapp.feature.auth.impl.domain.model

internal data class AuthorizationResult(
    val success: Boolean,
    val token: String? = null,
    val error: AuthorizationError? = null
)

internal enum class AuthorizationError {
    IncorrectCredentials
}