package com.arshapshap.paymentsapp.feature.auth.data.repository

import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationError
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override suspend fun isAuthorized(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun logIn(data: AuthorizationData): AuthorizationResult {
        Thread.sleep(5000)
        return AuthorizationResult(
            success = false,
            error = AuthorizationError.IncorrectCredentials
        )
    }

    override suspend fun logOut() {
        TODO("Not yet implemented")
    }
}