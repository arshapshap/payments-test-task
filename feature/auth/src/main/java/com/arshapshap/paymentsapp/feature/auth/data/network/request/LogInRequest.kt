package com.arshapshap.paymentsapp.feature.auth.data.network.request

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
internal data class LogInRequest(
    @SerialName("login")
    val login: String,
    @SerialName("password")
    val password: String
)