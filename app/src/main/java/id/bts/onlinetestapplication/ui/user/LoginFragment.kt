package id.bts.onlinetestapplication.ui.user

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import id.bts.onlinetestapplication.R
import id.bts.onlinetestapplication.databinding.LayoutLoginBinding
import id.bts.onlinetestapplication.network.bin.NetworkStatus
import id.bts.onlinetestapplication.ui.test.viewmodel.ActivityViewmodel
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment: Fragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private var _binding: LayoutLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ActivityViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {when (it.status) {
                NetworkStatus.SUCCESS -> {
                    it.data.let { raw ->
                        sharedPreferences.edit()
                            .putString("token", raw?.data?.token)
                            .apply()

                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                    }
                }
                NetworkStatus.LOADING -> {

                }
                NetworkStatus.ERROR -> {
                    Snackbar.make(binding.root, "Something went wrong", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }

        binding.apply {
            button.setOnClickListener {
                when {
                    editTextTextPassword.text.isNullOrEmpty() -> return@setOnClickListener
                    editTextTextPersonName.text.isNullOrEmpty() -> return@setOnClickListener
                    else -> proceedLogin()
                }
            }
        }
    }

    private fun proceedLogin() {
        viewModel.apply {
            binding.also {
                tryLogin(
                    it.editTextTextPersonName.text,
                    it.editTextTextPassword.text
                )
            }
        }
    }
}