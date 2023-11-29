package com.arshapshap.paymentsapp.feature.payments.domain.repository

import com.arshapshap.paymentsapp.feature.payments.domain.model.PaymentsResult

internal interface PaymentRepository {

    suspend fun getPayments(): PaymentsResult
}