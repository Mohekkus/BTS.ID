package id.bts.onlinetestapplication.ui.user

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.bts.onlinetestapplication.databinding.LayoutRegisterBinding
import id.bts.onlinetestapplication.ui.test.viewmodel.ActivityViewmodel

@AndroidEntryPoint
class RegisterFragment: Fragment() {

    private var _binding: LayoutRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ActivityViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {

        }
        binding.apply {
            button2.setOnClickListener {
                when {
                    editTextTextEmailAddress2.text.isNullOrEmpty() -> return@setOnClickListener
                    editTextTextPassword2.text.isNullOrEmpty() -> return@setOnClickListener
                    editTextTextPersonName2.text.isNullOrEmpty() -> return@setOnClickListener
                    else -> proceedRegister()
                }
            }
        }
    }

    private fun toastUser(message: String) {
        AlertDialog.Builder(requireActivity()).apply {
            setTitle("Information")
            setMessage(message)
            setPositiveButton("OK"
            ) { p0, p1 ->

            }
        }.create()
            .also {
                it.setCanceledOnTouchOutside(false)
            }.show()
    }

    private fun proceedRegister() {
        viewModel.apply {
            binding.also {
                tryRegister(
                    it.editTextTextPersonName2.text,
                    it.editTextTextPassword2.text,
                    it.editTextTextEmailAddress2.text
                )
            }
        }
    }
}