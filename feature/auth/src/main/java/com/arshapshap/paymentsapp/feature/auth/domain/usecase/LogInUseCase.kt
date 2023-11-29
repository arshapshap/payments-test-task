package com.arshapshap.paymentsapp.feature.auth.domain.usecase

import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.domain.repository.AuthRepository
import com.arshapshap.paymentsapp.feature.auth.domain.repository.TokenRepository

class LogInUseCase internal constructor(
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