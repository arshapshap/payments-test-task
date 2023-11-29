package com.arshapshap.paymentsapp.di

import com.arshapshap.paymentsapp.feature.auth.presentation.FeatureAuthRouter
import com.arshapshap.paymentsapp.navigation.Navigator
import org.koin.dsl.module

val appModule = module {

    // navigation
    single<Navigator> { Navigator() }
    single<FeatureAuthRouter> { get<Navigator>() }

}