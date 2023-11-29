package com.arshapshap.paymentsapp.feature.payments.di

import com.arshapshap.paymentsapp.feature.payments.data.mapper.PaymentsMapper
import com.arshapshap.paymentsapp.feature.payments.data.network.PaymentsApi
import com.arshapshap.paymentsapp.feature.payments.data.repository.PaymentRepositoryImpl
import com.arshapshap.paymentsapp.feature.payments.domain.repository.PaymentRepository
import com.arshapshap.paymentsapp.feature.payments.domain.usecase.GetPaymentsUseCase
import com.arshapshap.paymentsapp.feature.payments.presentation.screen.PaymentsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val featurePaymentsModule = module {

    // data
    factory<PaymentsApi> { get<Retrofit>().create(PaymentsApi::class.java) }

    factory<PaymentsMapper> { PaymentsMapper() }

    factory<PaymentRepository> { PaymentRepositoryImpl(remoteSource = get(), mapper = get()) }

    // domain
    factory<GetPaymentsUseCase> { GetPaymentsUseCase(get()) }

    // presentation
    viewModel<PaymentsViewModel> { PaymentsViewModel(get(), get(), get()) }
}