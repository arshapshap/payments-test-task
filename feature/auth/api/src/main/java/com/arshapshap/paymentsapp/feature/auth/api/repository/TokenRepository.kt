package com.arshapshap.paymentsapp.feature.auth.api.repository

interface TokenRepository {

    fun isAuthorized(): Boolean

    fun saveToken(token: String)

    fun deleteToken()
}