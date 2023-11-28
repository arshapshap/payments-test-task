package com.arshapshap.paymentsapp.feature.auth.domain.repository

import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationResult

internal interface AuthRepository {

    suspend fun isAuthorized(): Boolean

    suspend fun logIn(data: AuthorizationData): AuthorizationResult

    suspend fun logOut()
}