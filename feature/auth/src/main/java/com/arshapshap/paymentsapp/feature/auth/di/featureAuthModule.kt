package com.arshapshap.paymentsapp.feature.auth.di

import com.arshapshap.paymentsapp.feature.auth.data.repository.AuthRepositoryImpl
import com.arshapshap.paymentsapp.feature.auth.domain.repository.AuthRepository
import com.arshapshap.paymentsapp.feature.auth.domain.usecase.CheckAuthorizationUseCase
import com.arshapshap.paymentsapp.feature.auth.domain.usecase.LogInUseCase
import com.arshapshap.paymentsapp.feature.auth.domain.usecase.LogOutUseCase
import com.arshapshap.paymentsapp.feature.auth.presentation.screen.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureAuthModule = module {

    // data
    factory<AuthRepository> { AuthRepositoryImpl() }

    // domain
    factory<CheckAuthorizationUseCase> { CheckAuthorizationUseCase(get()) }
    factory<LogInUseCase> { LogInUseCase(get()) }
    factory<LogOutUseCase> { LogOutUseCase(get()) }

    // presentation
    viewModel<AuthViewModel> { AuthViewModel(get(), get()) }
}