package com.arshapshap.paymentsapp.feature.auth.data.mapper

import com.arshapshap.paymentsapp.feature.auth.data.network.request.LogInRequest
import com.arshapshap.paymentsapp.feature.auth.data.network.response.LoginResponse
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationError
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationResult

internal class AuthMapper {

    fun map(data: AuthorizationData): LogInRequest = LogInRequest(
        login = data.login,
        password = data.password
    )

    fun map(response: LoginResponse): AuthorizationResult = AuthorizationResult(
        success = response.success == "true" && response.response?.token != null,
        token = response.response?.token,
        error = when (response.error?.errorCode) {
            1003 -> AuthorizationError.IncorrectCredentials
            else -> null
        }
    )
}