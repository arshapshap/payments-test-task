package com.arshapshap.paymentsapp.feature.auth.di

import com.arshapshap.paymentsapp.feature.auth.data.network.AuthApi
import com.arshapshap.paymentsapp.feature.auth.data.mapper.AuthMapper
import com.arshapshap.paymentsapp.feature.auth.data.repository.AuthRepositoryImpl
import com.arshapshap.paymentsapp.feature.auth.data.repository.TokenRepositoryImpl
import com.arshapshap.paymentsapp.feature.auth.domain.repository.AuthRepository
import com.arshapshap.paymentsapp.feature.auth.domain.repository.TokenRepository
import com.arshapshap.paymentsapp.feature.auth.domain.usecase.CheckAuthorizationUseCase
import com.arshapshap.paymentsapp.feature.auth.domain.usecase.LogInUseCase
import com.arshapshap.paymentsapp.feature.auth.domain.usecase.LogOutUseCase
import com.arshapshap.paymentsapp.feature.auth.presentation.screen.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val featureAuthModule = module {

    // data
    factory<AuthApi> { get<Retrofit>().create(AuthApi::class.java) }

    factory<AuthMapper> { AuthMapper() }

    factory<AuthRepository> { AuthRepositoryImpl(remoteSource = get(), mapper = get()) }
    factory<TokenRepository> { TokenRepositoryImpl(tokenManager = get()) }

    // domain
    factory<CheckAuthorizationUseCase> { CheckAuthorizationUseCase(get()) }
    factory<LogInUseCase> { LogInUseCase(authRepository = get(), tokenRepository = get()) }
    factory<LogOutUseCase> { LogOutUseCase(get()) }

    // presentation
    viewModel<AuthViewModel> { AuthViewModel(get(), get()) }
}