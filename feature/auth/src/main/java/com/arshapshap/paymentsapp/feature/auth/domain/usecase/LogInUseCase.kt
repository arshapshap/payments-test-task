package com.arshapshap.paymentsapp.feature.auth.domain.usecase

import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.domain.repository.AuthRepository

class LogInUseCase internal constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(data: AuthorizationData): AuthorizationResult {
        return repository.logIn(data)
    }
}