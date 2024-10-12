package com.arquitectura.triviapp.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arquitectura.triviapp.R
import com.arquitectura.triviapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enable view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //transition to splash screen fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, LoginFragment())
                .commit()
        }
    }

    override fun onBackPressed() {

    }

}