package com.arshapshap.paymentsapp.navigation

import androidx.navigation.NavController
import com.arshapshap.paymentsapp.R
import com.arshapshap.paymentsapp.feature.auth.impl.presentation.FeatureAuthRouter
import com.arshapshap.paymentsapp.feature.payments.presentation.FeaturePaymentsRouter
import com.arshapshap.paymentsapp.presentation.MainRouter

class Navigator : FeatureAuthRouter, FeaturePaymentsRouter, MainRouter {

    private var navController: NavController? = null

    fun attachNavController(navController: NavController, graph: Int) {
        navController.setGraph(graph)
        this.navController = navController
    }

    fun detachNavController(navController: NavController) {
        if (this.navController == navController) {
            this.navController = null
        }
    }

    override fun openPaymentsFromAuthorization() {
        navController?.navigate(R.id.action_fragment_auth_to_fragment_payments)
    }

    override fun openAuthorizationFromPayments() {
        navController?.navigate(R.id.action_fragment_payments_to_fragment_auth)
    }

    override fun openPaymentsListFromSplash() {
        navController?.navigate(R.id.action_fragment_splash_to_fragment_payments)
    }

    override fun openAuthorizationFromSplash() {
        navController?.navigate(R.id.action_fragment_splash_to_fragment_auth)
    }
}