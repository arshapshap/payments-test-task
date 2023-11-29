package com.arshapshap.paymentsapp.core.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    protected val _error: MutableLiveData<BaseError> = MutableLiveData()
    val error: LiveData<BaseError> = _error
}

interface BaseError {

    data object NetworkError : BaseError
}