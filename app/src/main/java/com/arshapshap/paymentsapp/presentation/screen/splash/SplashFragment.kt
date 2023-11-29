package com.arshapshap.paymentsapp.presentation.screen.splash

import com.arshapshap.paymentsapp.core.presentation.BaseFragment
import com.arshapshap.paymentsapp.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(
    FragmentSplashBinding::inflate
) {

    override val viewModel: SplashViewModel by viewModel()

    override fun initViews() { }

    override fun subscribe() {
        viewModel.checkAuthorization()
    }
}