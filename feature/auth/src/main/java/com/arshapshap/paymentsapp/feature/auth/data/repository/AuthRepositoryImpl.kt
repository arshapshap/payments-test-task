package com.arshapshap.paymentsapp.feature.auth.data.repository

import com.arshapshap.paymentsapp.feature.auth.data.network.AuthApi
import com.arshapshap.paymentsapp.feature.auth.data.mapper.AuthMapper
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.domain.repository.AuthRepository

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