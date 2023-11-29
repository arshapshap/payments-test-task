package com.arshapshap.paymentsapp.feature.auth.impl.data.network.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LoginResponse(
    @SerialName("success")
    val success: String,
    @SerialName("response")
    val response: Response? = null,
    @SerialName("error")
    val error: Error? = null
)

@Serializable
internal data class Response(
    @SerialName("token")
    val token: String
)

@Serializable
internal data class Error(
    @SerialName("error_code")
    val errorCode: Int,
    @SerialName("error_msg")
    val errorMsg: String
)