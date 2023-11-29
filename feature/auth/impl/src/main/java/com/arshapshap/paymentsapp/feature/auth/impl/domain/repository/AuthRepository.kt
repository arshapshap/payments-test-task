package com.arshapshap.paymentsapp.feature.auth.impl.domain.repository

import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationResult

internal interface AuthRepository {

    suspend fun logIn(data: AuthorizationData): AuthorizationResult
}