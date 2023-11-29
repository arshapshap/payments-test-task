package com.arshapshap.paymentsapp.feature.auth.presentation.screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.arshapshap.paymentsapp.core.presentation.BaseError
import com.arshapshap.paymentsapp.core.presentation.BaseViewModel
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationData
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationError
import com.arshapshap.paymentsapp.feature.auth.domain.model.AuthorizationResult
import com.arshapshap.paymentsapp.feature.auth.domain.usecase.LogInUseCase
import com.arshapshap.paymentsapp.feature.auth.presentation.FeatureAuthRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class AuthViewModel(
    private val logInUseCase: LogInUseCase,
    private val router: FeatureAuthRouter
) : BaseViewModel() {

    init {
        _isLoading.value = false
    }

    fun logIn(login: String, password: String) {
        if (isCredentialsBlank(login, password)) return

        _error.value = AuthError.IncorrectCredentials(actual = false)
        _isLoading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = logInUseCase.invoke(AuthorizationData(login, password))
                if (!result.success)
                    handleAuthorizationError(result)
                else
                    navigate()
            } catch (e: Exception) {
                //TODO("Catch network errors")
                Log.e("NETWORK", e.toString())
                _error.postValue(BaseError.NetworkError)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun loginChanged(login: String) {
        if (_error.value is AuthError.IncorrectCredentials)
            _error.value = AuthError.IncorrectCredentials(actual = false)
        _error.value = AuthError.EmptyLogin(actual = login.isBlank())
    }

    fun passwordChanged(password: String) {
        if (_error.value is AuthError.IncorrectCredentials)
            _error.value = AuthError.IncorrectCredentials(actual = false)
        _error.value = AuthError.EmptyPassword(actual = password.isBlank())
    }

    private fun isCredentialsBlank(login: String, password: String): Boolean {
        if (login.isBlank()) _error.value = AuthError.EmptyLogin()
        if (password.isBlank()) _error.value = AuthError.EmptyPassword()

        return login.isBlank() || password.isBlank()
    }

    private fun navigate() {
        router.openPaymentsList()
    }

    private fun handleAuthorizationError(result: AuthorizationResult) {
        when (result.error) {
            AuthorizationError.IncorrectCredentials -> _error.postValue(AuthError.IncorrectCredentials())
            null -> { }
        }
    }
}