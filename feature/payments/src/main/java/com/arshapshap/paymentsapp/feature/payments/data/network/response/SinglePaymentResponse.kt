package com.arshapshap.paymentsapp.feature.payments.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SinglePaymentResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("amount")
    @Serializable(with = AmountValueSerializer::class)
    val amount: AmountValue? = null,
    @SerialName("created")
    val created: Int? = null
)

@Serializable
internal sealed class AmountValue {
    data class IntAmount(val value: Int) : AmountValue()
    data class DoubleAmount(val value: Double) : AmountValue()
    data class StringAmount(val value: String) : AmountValue()
}