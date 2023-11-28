package com.arshapshap.paymentsapp.feature.auth.domain.usecase

import com.arshapshap.paymentsapp.feature.auth.domain.repository.AuthRepository

class CheckAuthorizationUseCase internal constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): Boolean = repository.isAuthorized()
}