package com.arquitectura.triviapp.Vista

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.arquitectura.triviapp.R
import com.arquitectura.triviapp.Servicios.LoginViewModel
import com.arquitectura.triviapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.loginBtn.setOnClickListener {

            if (binding.username.text.toString().trim().isNotEmpty() &&
                binding.password.text.toString().trim().isNotEmpty()
            ) {

                //check if user is registered in the app or not
                viewModel.checkIfUserIsRegistered(
                    binding.username.text.toString().trim(),
                    binding.password.text.toString().trim()
                )
                    .observe(viewLifecycleOwner) { loginDetailsList ->
                        //fetch data and returns list of users if registered
                        //check if user already exist in database
                        if (loginDetailsList.isNotEmpty()) {
                            Toast.makeText(
                                requireContext(),
                                "Login successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            //move to home screen of quiz
                            val intent = Intent(requireContext(), HomeScreenActivity::class.java)
                            intent.putExtra("username", binding.username.text.toString().trim())
                            intent.putExtra("password", binding.password.text.toString().trim())
                            intent.putExtra("id", loginDetailsList[0].id.toString())
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "User not found",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(
                    requireContext(),
                    "All fields must be non empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        //sign up user, if does not exist already
        binding.signUp.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer, SignUpFragment())
                    .commit()
            }
        }

        //exit app
        binding.exitBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            startActivity(intent)
        }

        return binding.root
    }

}