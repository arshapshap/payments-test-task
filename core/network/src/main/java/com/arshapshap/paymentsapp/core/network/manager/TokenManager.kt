package com.arshapshap.paymentsapp.core.network.manager

interface TokenManager {

    fun getToken(): String?

    fun saveToken(token: String)
}