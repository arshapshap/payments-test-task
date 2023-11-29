package com.arshapshap.paymentsapp.feature.auth.impl.di

import com.arshapshap.paymentsapp.feature.auth.impl.data.network.AuthApi
import com.arshapshap.paymentsapp.feature.auth.impl.data.mapper.AuthMapper
import com.arshapshap.paymentsapp.feature.auth.impl.data.repository.AuthRepositoryImpl
import com.arshapshap.paymentsapp.feature.auth.impl.data.repository.TokenRepositoryImpl
import com.arshapshap.paymentsapp.feature.auth.impl.domain.repository.AuthRepository
import com.arshapshap.paymentsapp.feature.auth.api.repository.TokenRepository
import com.arshapshap.paymentsapp.feature.auth.api.usecase.CheckAuthorizationUseCase
import com.arshapshap.paymentsapp.feature.auth.impl.domain.usecase.LogInUseCase
import com.arshapshap.paymentsapp.feature.auth.api.usecase.LogOutUseCase
import com.arshapshap.paymentsapp.feature.auth.impl.presentation.screen.AuthViewModel
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