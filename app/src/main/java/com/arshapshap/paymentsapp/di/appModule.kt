package com.arshapshap.paymentsapp.di

import com.arshapshap.paymentsapp.feature.auth.impl.presentation.FeatureAuthRouter
import com.arshapshap.paymentsapp.feature.payments.presentation.FeaturePaymentsRouter
import com.arshapshap.paymentsapp.navigation.Navigator
import com.arshapshap.paymentsapp.presentation.MainRouter
import com.arshapshap.paymentsapp.presentation.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // navigation
    single<Navigator> { Navigator() }
    single<MainRouter> { get<Navigator>() }
    single<FeatureAuthRouter> { get<Navigator>() }
    single<FeaturePaymentsRouter> { get<Navigator>() }

    // presentation
    viewModel<SplashViewModel> { SplashViewModel(get(), get()) }
}