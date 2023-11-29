package com.arshapshap.paymentsapp.feature.auth.impl.data.repository

import com.arshapshap.paymentsapp.feature.auth.impl.data.network.AuthApi
import com.arshapshap.paymentsapp.feature.auth.impl.data.mapper.AuthMapper
import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.impl.domain.repository.AuthRepository

internal class AuthRepositoryImpl(
    private val remoteSource: AuthApi,
    private val mapper: AuthMapper
) : AuthRepository {

    override suspend fun logIn(data: AuthorizationData): AuthorizationResult {
        val logInRequest = mapper.map(data)
        val logInResponse = remoteSource.logIn(logInRequest)

        return mapper.map(logInResponse)
    }
}