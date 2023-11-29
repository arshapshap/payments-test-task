package com.arshapshap.paymentsapp.feature.auth.domain.usecase

import com.arshapshap.paymentsapp.feature.auth.domain.repository.TokenRepository

class LogOutUseCase internal constructor(
    private val repository: TokenRepository
) {

    operator fun invoke() = repository.deleteToken()
}