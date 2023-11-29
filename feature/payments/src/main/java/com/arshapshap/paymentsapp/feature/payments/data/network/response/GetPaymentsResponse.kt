package com.arshapshap.paymentsapp.feature.payments.data.network.response
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
internal data class GetPaymentsResponse(
    @SerialName("success")
    val success: String,
    @SerialName("response")
    val payments: List<SinglePaymentResponse>? = null,
    @SerialName("error")
    val error: Error? = null
)

@Serializable
internal data class Error(
    @SerialName("error_code")
    val errorCode: Int,
    @SerialName("error_msg")
    val errorMsg: String
)