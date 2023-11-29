package com.arshapshap.paymentsapp.feature.auth.impl.data.network

import com.arshapshap.paymentsapp.feature.auth.impl.data.network.request.LogInRequest
import com.arshapshap.paymentsapp.feature.auth.impl.data.network.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthApi {

    @POST("login")
    suspend fun logIn(@Body data: LogInRequest): LoginResponse
}