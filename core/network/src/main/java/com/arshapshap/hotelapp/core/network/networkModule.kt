package com.arshapshap.hotelapp.core.network

import com.arshapshap.paymentsapp.core.network.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val networkModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single<Retrofit> {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl(BuildConfig.BASE_API_URL)
            .build()
    }
}