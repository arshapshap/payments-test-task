package com.arshapshap.paymentsapp

import android.app.Application
import com.arshapshap.paymentsapp.core.network.networkModule
import com.arshapshap.paymentsapp.di.appModule
import com.arshapshap.paymentsapp.feature.auth.di.featureAuthModule
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                appModule,
                featureAuthModule,
                networkModule
            )
        }
    }
}