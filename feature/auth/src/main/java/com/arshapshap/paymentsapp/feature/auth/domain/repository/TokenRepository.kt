package com.arshapshap.paymentsapp.feature.auth.domain.repository

internal interface TokenRepository {

    fun isAuthorized(): Boolean

    fun saveToken(token: String)

    fun deleteToken()
}