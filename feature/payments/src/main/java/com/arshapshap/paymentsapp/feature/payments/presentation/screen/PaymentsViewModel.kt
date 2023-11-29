package com.arshapshap.paymentsapp.feature.payments.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arshapshap.paymentsapp.core.presentation.BaseError
import com.arshapshap.paymentsapp.core.presentation.BaseViewModel
import com.arshapshap.paymentsapp.feature.auth.api.usecase.LogOutUseCase
import com.arshapshap.paymentsapp.feature.payments.domain.model.Payment
import com.arshapshap.paymentsapp.feature.payments.domain.model.PaymentsResult
import com.arshapshap.paymentsapp.feature.payments.domain.model.RequestError
import com.arshapshap.paymentsapp.feature.payments.domain.usecase.GetPaymentsUseCase
import com.arshapshap.paymentsapp.feature.payments.presentation.FeaturePaymentsRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

internal class PaymentsViewModel(
    private val getPaymentsUseCase: GetPaymentsUseCase,
    private val logOutUseCase: LogOutUseCase,
    private val router: FeaturePaymentsRouter
) : BaseViewModel() {

    private val _payments: MutableLiveData<List<Payment>> = MutableLiveData()
    val payments: LiveData<List<Payment>> = _payments

    init {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getPaymentsUseCase.invoke()
                if (result.success)
                    _payments.postValue(result.payments!!)
                else
                    handleError(result)
            } catch (e: Exception) {
                val error = when (e) {
                    is UnknownHostException -> BaseError.NetworkError
                    else -> BaseError.UnknownError
                }
                _error.postValue(error)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun logOut() {
        logOutUseCase.invoke()
        router.openAuthorizationFromPayments()
    }

    private fun handleError(result: PaymentsResult) {
        when (result.error) {
            RequestError.IncorrectToken -> _error.postValue(PaymentsViewModelError.IncorrectToken)
            else -> _error.postValue(BaseError.UnknownError)
        }
    }
}