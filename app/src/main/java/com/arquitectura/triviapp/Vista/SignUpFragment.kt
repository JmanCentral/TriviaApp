package com.arquitectura.triviapp.Vista

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.arquitectura.triviapp.Entidades.LoginCredentials
import com.arquitectura.triviapp.R
import com.arquitectura.triviapp.Servicios.LoginViewModel
import com.arquitectura.triviapp.databinding.FragmentSignUpBinding
import java.util.regex.Pattern

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        binding.createBtn.setOnClickListener {

            //check is user name exists to avoid duplicate user name in the app
            //returns list of users if that users exist with the name passed as argument below
            viewModel.checkUsernameExists(binding.username.text.toString().trim())
                .observe(viewLifecycleOwner) {
                    if (it.isEmpty()) {
                        if (binding.username.text.toString().trim().isNotEmpty() &&
                            binding.password.text.toString().trim().isNotEmpty() &&
                            binding.email.text.toString().trim().isNotEmpty()
                        ) {

                            if (isValidEmailId(binding.email.text.toString().trim())) {
                                viewModel.insert(
                                    LoginCredentials(
                                        id = null,
                                        username = binding.username.text.toString().trim(),
                                        password = binding.password.text.toString().trim(),
                                        email = binding.email.text.toString().trim()
                                    )
                                )
                                Toast.makeText(
                                    requireContext(),
                                    "Account created",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()

                                Handler(Looper.getMainLooper()).postDelayed({
                                    fragmentManager?.beginTransaction()?.apply {
                                        replace(R.id.fragmentContainer, LoginFragment())
                                            .commit()
                                    }
                                }, 1000)

                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Enter a valid email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "All fields must be non empty",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Username already exists",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

        }

        binding.backBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer, LoginFragment())
                    .commit()
            }
        }

        return binding.root
    }

    private fun isValidEmailId(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

}