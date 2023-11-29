package com.arshapshap.paymentsapp.feature.payments.data.network

import com.arshapshap.paymentsapp.feature.payments.data.network.response.GetPaymentsResponse
import retrofit2.http.GET

internal interface PaymentsApi {

    @GET("payments")
    suspend fun getPayments(): GetPaymentsResponse
}