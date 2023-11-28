package com.arshapshap.paymentsapp.feature.auth.domain.model

data class AuthorizationResult(
    val success: Boolean,
    val token: String? = null,
    val error: AuthorizationError? = null
)

enum class AuthorizationError {
    IncorrectCredentials
}