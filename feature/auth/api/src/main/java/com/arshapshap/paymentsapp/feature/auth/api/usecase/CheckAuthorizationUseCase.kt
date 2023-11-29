package com.arshapshap.paymentsapp.feature.auth.api.usecase

import com.arshapshap.paymentsapp.feature.auth.api.repository.TokenRepository

class CheckAuthorizationUseCase(
    private val repository: TokenRepository
) {

    operator fun invoke(): Boolean = repository.isAuthorized()
}