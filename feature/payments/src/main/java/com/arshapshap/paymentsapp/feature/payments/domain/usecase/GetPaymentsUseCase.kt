package com.arshapshap.paymentsapp.feature.payments.domain.usecase

import com.arshapshap.paymentsapp.feature.payments.domain.model.PaymentsResult
import com.arshapshap.paymentsapp.feature.payments.domain.repository.PaymentRepository

internal class GetPaymentsUseCase(
    private val repository: PaymentRepository
) {

    suspend operator fun invoke(): PaymentsResult {
        return repository.getPayments()
    }
}