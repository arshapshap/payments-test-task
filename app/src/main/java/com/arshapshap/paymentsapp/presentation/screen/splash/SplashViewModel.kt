package com.arshapshap.paymentsapp.presentation.screen.splash

import com.arshapshap.paymentsapp.core.presentation.BaseViewModel
import com.arshapshap.paymentsapp.feature.auth.api.usecase.CheckAuthorizationUseCase
import com.arshapshap.paymentsapp.presentation.MainRouter

internal class SplashViewModel(
    private val checkAuthorizationUseCase: CheckAuthorizationUseCase,
    private val router: MainRouter
) : BaseViewModel() {

    fun checkAuthorization() {
        val isAuthorized = checkAuthorizationUseCase.invoke()
        if (isAuthorized)
            router.openPaymentsListFromSplash()
        else
            router.openAuthorizationFromSplash()
    }
}