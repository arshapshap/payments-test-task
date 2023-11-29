package com.arshapshap.paymentsapp.feature.auth.impl.domain.usecase

import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.impl.domain.repository.AuthRepository
import com.arshapshap.paymentsapp.feature.auth.api.repository.TokenRepository

internal class LogInUseCase(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke(data: AuthorizationData): AuthorizationResult {
        val result = authRepository.logIn(data)

        if (result.success && result.token != null)
            tokenRepository.saveToken(result.token)

        return result
    }
}