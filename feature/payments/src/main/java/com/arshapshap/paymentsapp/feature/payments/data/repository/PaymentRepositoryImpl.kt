package com.arshapshap.paymentsapp.feature.payments.data.repository

import com.arshapshap.paymentsapp.feature.payments.data.mapper.PaymentsMapper
import com.arshapshap.paymentsapp.feature.payments.data.network.PaymentsApi
import com.arshapshap.paymentsapp.feature.payments.domain.model.PaymentsResult
import com.arshapshap.paymentsapp.feature.payments.domain.repository.PaymentRepository

internal class PaymentRepositoryImpl(
    private val remoteSource: PaymentsApi,
    private val mapper: PaymentsMapper
) : PaymentRepository {

    override suspend fun getPayments(): PaymentsResult {
        val paymentsResponse = remoteSource.getPayments()
        return mapper.map(paymentsResponse)
    }
}