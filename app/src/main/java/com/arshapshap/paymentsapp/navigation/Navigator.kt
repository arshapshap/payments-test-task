package com.arshapshap.paymentsapp.navigation

import androidx.navigation.NavController
import com.arshapshap.paymentsapp.R
import com.arshapshap.paymentsapp.feature.auth.impl.presentation.FeatureAuthRouter
import com.arshapshap.paymentsapp.feature.payments.presentation.FeaturePaymentsRouter

class Navigator : FeatureAuthRouter, FeaturePaymentsRouter {

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

    override fun openPaymentsList() {
        navController?.navigate(R.id.action_fragment_auth_to_fragment_payments)
    }

    override fun openAuthorization() {
        navController?.navigate(R.id.action_fragment_payments_to_fragment_auth)
    }
}