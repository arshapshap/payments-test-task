package com.arshapshap.paymentsapp.core.network.interceptor

import com.arshapshap.paymentsapp.core.network.Headers
import com.arshapshap.paymentsapp.core.network.manager.TokenManager
import okhttp3.Interceptor
import okhttp3.Response

internal class TokenInterceptor(
    private val tokenManager: TokenManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenManager.getToken() ?: return chain.proceed(chain.request())

        val request = chain.request().newBuilder()
            .addHeader(Headers.Token.key, token)
            .build()

        return chain.proceed(request)
    }
}