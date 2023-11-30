package com.arshapshap.paymentsapp.feature.auth.impl.presentation.screen

import androidx.lifecycle.viewModelScope
import com.arshapshap.paymentsapp.core.presentation.BaseError
import com.arshapshap.paymentsapp.core.presentation.BaseViewModel
import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationError
import com.arshapshap.paymentsapp.feature.auth.impl.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.impl.domain.usecase.LogInUseCase
import com.arshapshap.paymentsapp.feature.auth.impl.presentation.FeatureAuthRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

internal class AuthViewModel(
    private val logInUseCase: LogInUseCase,
    private val router: FeatureAuthRouter
) : BaseViewModel() {

    fun logIn(login: String, password: String) {
        if (isCredentialsBlank(login, password)) return

        _error.value = AuthViewModelError.IncorrectCredentials(actual = false)
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = logInUseCase.invoke(AuthorizationData(login, password))
                if (!result.success)
                    handleAuthorizationError(result)
                else {
                    launch(Dispatchers.Main) {
                        navigate()
                    }
                }
            } catch (e: Exception) {
                val error = when (e) {
                    is UnknownHostException -> BaseError.NetworkError
                    else -> BaseError.UnknownError(e.toString())
                }
                _error.postValue(error)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun loginChanged(login: String) {
        if (_error.value is AuthViewModelError.IncorrectCredentials)
            _error.value = AuthViewModelError.IncorrectCredentials(actual = false)
        _error.value = AuthViewModelError.EmptyLogin(actual = login.isBlank())
    }

    fun passwordChanged(password: String) {
        if (_error.value is AuthViewModelError.IncorrectCredentials)
            _error.value = AuthViewModelError.IncorrectCredentials(actual = false)
        _error.value = AuthViewModelError.EmptyPassword(actual = password.isBlank())
    }

    private fun isCredentialsBlank(login: String, password: String): Boolean {
        if (login.isBlank()) _error.value = AuthViewModelError.EmptyLogin()
        if (password.isBlank()) _error.value = AuthViewModelError.EmptyPassword()

        return login.isBlank() || password.isBlank()
    }

    private fun navigate() {
        router.openPaymentsFromAuthorization()
    }

    private fun handleAuthorizationError(result: AuthorizationResult) {
        when (result.error) {
            AuthorizationError.IncorrectCredentials -> _error.postValue(AuthViewModelError.IncorrectCredentials())
            else -> _error.postValue(BaseError.UnknownError())
        }
    }
}