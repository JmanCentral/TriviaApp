package com.arquitectura.triviapp.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.arquitectura.triviapp.Servicios.LoginViewModel
import com.arquitectura.triviapp.databinding.ActivityEditPasswordBinding

class EditPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPasswordBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("user").toString()
        //already present in database
        val password = intent.getStringExtra("password").toString()
        val id = intent.getStringExtra("id").toString().toInt()

        binding.changePasswordBtn.setOnClickListener {

            if (binding.newPassword.text.toString()
                    .isEmpty() || binding.oldPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "All fields must be non empty", Toast.LENGTH_SHORT).show()
            } else if (binding.oldPassword.text.toString().trim() != password) {
                Toast.makeText(this, "Old password is incorrect", Toast.LENGTH_SHORT).show()
            } else if (binding.newPassword.text.toString() == password) {
                Toast.makeText(this, "Old password is same as New password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Password updated", Toast.LENGTH_SHORT)
                    .show()

                viewModel.update(binding.newPassword.text.toString(), username)
            }
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}
