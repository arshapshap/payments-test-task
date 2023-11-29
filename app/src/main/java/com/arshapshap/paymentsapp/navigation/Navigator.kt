package com.arshapshap.paymentsapp.navigation

import androidx.navigation.NavController
import com.arshapshap.paymentsapp.feature.auth.presentation.FeatureAuthRouter

class Navigator : FeatureAuthRouter {

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
        TODO("Not yet implemented")
    }
}