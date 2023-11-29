package com.arshapshap.paymentsapp

import android.app.Application
import com.arshapshap.paymentsapp.core.network.networkModule
import com.arshapshap.paymentsapp.di.appModule
import com.arshapshap.paymentsapp.feature.auth.impl.di.featureAuthModule
import com.arshapshap.paymentsapp.feature.payments.di.featurePaymentsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                appModule,
                featureAuthModule,
                featurePaymentsModule,
                networkModule
            )
        }
    }
}