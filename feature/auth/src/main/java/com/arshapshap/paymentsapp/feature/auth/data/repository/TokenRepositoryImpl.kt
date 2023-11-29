package com.arshapshap.paymentsapp.feature.auth.data.repository

import com.arshapshap.paymentsapp.core.network.manager.TokenManager
import com.arshapshap.paymentsapp.feature.auth.domain.repository.TokenRepository

internal class TokenRepositoryImpl(
    private val tokenManager: TokenManager
) : TokenRepository {

    override fun isAuthorized(): Boolean {
        return tokenManager.getToken() != null
    }

    override fun saveToken(token: String) {
        tokenManager.saveToken(token)
    }

    override fun deleteToken() {
        tokenManager.deleteToken()
    }
}