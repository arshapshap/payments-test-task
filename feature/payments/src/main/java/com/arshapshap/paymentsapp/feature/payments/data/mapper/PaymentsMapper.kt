package com.arshapshap.paymentsapp.feature.payments.data.mapper

import com.arshapshap.paymentsapp.feature.payments.data.network.response.AmountValue
import com.arshapshap.paymentsapp.feature.payments.data.network.response.GetPaymentsResponse
import com.arshapshap.paymentsapp.feature.payments.data.network.response.SinglePaymentResponse
import com.arshapshap.paymentsapp.feature.payments.domain.model.Payment
import com.arshapshap.paymentsapp.feature.payments.domain.model.PaymentsResult
import com.arshapshap.paymentsapp.feature.payments.domain.model.RequestError
import java.util.Date

internal class PaymentsMapper {

    fun map(response: GetPaymentsResponse): PaymentsResult = PaymentsResult(
        success = response.success == "true" && response.payments != null,
        payments = response.payments?.map { map(it) },
        error = when (response.error?.errorCode) {
            1001 -> RequestError.IncorrectToken
            else -> null
        }
    )

    private fun map(paymentResponse: SinglePaymentResponse): Payment = Payment(
        id = paymentResponse.id,
        title = paymentResponse.title,
        amount = when (paymentResponse.amount) {
            is AmountValue.IntAmount -> paymentResponse.amount.value.toDouble()
            is AmountValue.DoubleAmount -> paymentResponse.amount.value
            is AmountValue.StringAmount -> paymentResponse.amount.value.toDoubleOrNull()
            else -> null
        },
        created = paymentResponse.created?.let { Date(it.toLong() * 1000) }
    )
}