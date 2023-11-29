package com.arshapshap.paymentsapp.feature.auth.api.usecase

import com.arshapshap.paymentsapp.feature.auth.api.repository.TokenRepository

class LogOutUseCase(
    private val repository: TokenRepository
) {

    operator fun invoke() = repository.deleteToken()
}