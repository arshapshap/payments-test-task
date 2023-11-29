package com.arshapshap.paymentsapp.feature.auth.impl.presentation.screen

import androidx.core.view.children
import androidx.core.view.isGone
import androidx.core.widget.doAfterTextChanged
import com.arshapshap.paymentsapp.core.presentation.BaseError
import com.arshapshap.paymentsapp.core.presentation.BaseFragment
import com.arshapshap.paymentsapp.core.presentation.utils.showToast
import com.arshapshap.paymentsapp.feature.auth.impl.R
import com.arshapshap.paymentsapp.feature.auth.impl.databinding.FragmentAuthBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class AuthFragment : BaseFragment<FragmentAuthBinding, AuthViewModel>(
    FragmentAuthBinding::inflate
) {

    override val viewModel: AuthViewModel by viewModel()

    override fun initViews() {
        with (binding) {
            buttonLogIn.setOnClickListener {
                viewModel.logIn(
                    login = editTextLogin.text.toString(),
                    password = editTextPassword.text.toString()
                )
            }

            editTextLogin.doAfterTextChanged {
                viewModel.loginChanged(it.toString())
            }

            editTextPassword.doAfterTextChanged {
                viewModel.passwordChanged(it.toString())
            }
        }
    }

    override fun subscribe() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            setContentEnabled(!it)
            binding.progressBarLoading.isGone = !it
        }

        viewModel.error.observe(viewLifecycleOwner) {
            when (it) {
                is AuthViewModelError.EmptyLogin -> {
                    binding.textInputLogin.error = if (it.actual) getString(R.string.empty_login) else null
                }
                is AuthViewModelError.EmptyPassword -> {
                    binding.textInputPassword.error = if (it.actual) getString(R.string.empty_password) else null
                }
                is AuthViewModelError.IncorrectCredentials -> {
                    binding.textInputLogin.error = if (it.actual) getString(R.string.whitespace) else null
                    binding.textInputPassword.error = if (it.actual) getString(R.string.incorrect_credentials) else null
                }
                is BaseError.NetworkError -> {
                    requireContext().showToast(getString(com.arshapshap.paymentsapp.core.designsystem.R.string.network_error))
                }
                is BaseError.UnknownError -> {
                    requireContext().showToast(getString(com.arshapshap.paymentsapp.core.designsystem.R.string.unknown_error))
                }
            }
        }
    }

    private fun setContentEnabled(isEnabled: Boolean) {
        binding.layoutContent.alpha = if (isEnabled) 1f else 0.5f
        binding.layoutContent.children.forEach {
            it.isClickable = isEnabled
            it.isEnabled = isEnabled
        }
    }
}