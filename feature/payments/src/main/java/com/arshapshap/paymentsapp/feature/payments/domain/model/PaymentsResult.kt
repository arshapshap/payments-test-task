package com.arshapshap.paymentsapp.feature.payments.domain.model

internal data class PaymentsResult(
    val success: Boolean,
    val payments: List<Payment>?,
    val error: RequestError?
)

internal enum class RequestError {
    IncorrectToken
}