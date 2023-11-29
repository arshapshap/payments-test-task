package com.arshapshap.paymentsapp.presentation

import androidx.navigation.fragment.NavHostFragment
import com.arshapshap.paymentsapp.R
import com.arshapshap.paymentsapp.core.presentation.BaseActivity
import com.arshapshap.paymentsapp.databinding.ActivityMainBinding
import com.arshapshap.paymentsapp.navigation.Navigator
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    private val navigator: Navigator by inject()

    override fun initViews() {
        navigator.attachNavController(getNavController(), R.navigation.nav_graph)
    }

    override fun onDestroy() {
        navigator.detachNavController(getNavController())
        super.onDestroy()
    }

    private fun getNavController() =
        (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
}