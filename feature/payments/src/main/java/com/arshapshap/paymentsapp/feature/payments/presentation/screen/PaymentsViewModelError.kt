package com.arshapshap.paymentsapp.feature.payments.presentation.screen

import com.arshapshap.paymentsapp.core.presentation.BaseError

internal interface PaymentsViewModelError : BaseError {

    data object IncorrectToken : PaymentsViewModelError
}