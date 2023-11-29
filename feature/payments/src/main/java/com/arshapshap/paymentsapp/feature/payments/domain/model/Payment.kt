package com.arshapshap.paymentsapp.feature.payments.domain.model

import java.util.Date

internal data class Payment(
    val id: Int,
    val title: String,
    val amount: Double?,
    val created: Date?
)
