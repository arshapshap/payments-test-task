package com.arshapshap.paymentsapp.core.network

import com.arshapshap.paymentsapp.core.network.interceptor.MainInterceptor
import com.arshapshap.paymentsapp.core.network.interceptor.TokenInterceptor
import com.arshapshap.paymentsapp.core.network.manager.TokenManager
import com.arshapshap.paymentsapp.core.network.manager.TokenManagerImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory<TokenManager> { TokenManagerImpl(context = get()) }

    factory<MainInterceptor> { MainInterceptor() }
    factory<TokenInterceptor> { TokenInterceptor(tokenManager = get()) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(get<MainInterceptor>())
            .addInterceptor(get<TokenInterceptor>())
            .build()
    }

    single<Retrofit> {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(get<OkHttpClient>())
            .baseUrl(BuildConfig.BASE_API_URL)
            .build()
    }
}