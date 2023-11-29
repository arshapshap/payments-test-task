package com.arshapshap.paymentsapp.feature.payments.presentation.screen

import androidx.core.view.isGone
import com.arshapshap.paymentsapp.core.presentation.BaseError
import com.arshapshap.paymentsapp.core.presentation.BaseFragment
import com.arshapshap.paymentsapp.core.presentation.utils.showToast
import com.arshapshap.paymentsapp.feature.payments.databinding.FragmentPaymentsBinding
import com.arshapshap.paymentsapp.feature.payments.presentation.screen.recyclerview.PaymentsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class PaymentsFragment : BaseFragment<FragmentPaymentsBinding, PaymentsViewModel>(
    FragmentPaymentsBinding::inflate
) {

    override val viewModel: PaymentsViewModel by viewModel()

    override fun initViews() {
        with (binding) {
            recyclerViewPayments.adapter = PaymentsAdapter()

            buttonLogOut.setOnClickListener {
                viewModel.logOut()
            }
        }
    }

    override fun subscribe() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBarLoading.isGone = !it
        }

        viewModel.error.observe(viewLifecycleOwner) {
            when (it) {
                is BaseError.NetworkError -> {
                    requireContext().showToast(getString(com.arshapshap.paymentsapp.core.designsystem.R.string.network_error))
                }
                is BaseError.UnknownError -> {
                    requireContext().showToast(getString(com.arshapshap.paymentsapp.core.designsystem.R.string.unknown_error))
                }
            }
        }

        viewModel.payments.observe(viewLifecycleOwner) {
            getPaymentsAdapter().setList(it)
        }
    }

    private fun getPaymentsAdapter(): PaymentsAdapter =
        binding.recyclerViewPayments.adapter as PaymentsAdapter
}