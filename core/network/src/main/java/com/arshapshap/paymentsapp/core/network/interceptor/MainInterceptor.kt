package com.arshapshap.paymentsapp.core.network.interceptor

import com.arshapshap.paymentsapp.core.network.BuildConfig
import com.arshapshap.paymentsapp.core.network.Headers
import okhttp3.Interceptor
import okhttp3.Response

internal class MainInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(Headers.AppKey.key, BuildConfig.APP_KEY)
            .addHeader(Headers.Version.key, BuildConfig.API_VERSION)
            .build()
        return chain.proceed(request)
    }
}