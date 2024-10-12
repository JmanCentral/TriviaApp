package com.arquitectura.triviapp.Vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arquitectura.triviapp.databinding.ActivitySubjectBinding

class SubjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("username").toString()
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        binding.Geography.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("subject", "Geography")
            intent.putExtra("user", userName)
            startActivity(intent)
        }

        binding.math.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("subject", "Math")
            intent.putExtra("user", userName)
            startActivity(intent)
        }

        binding.literature.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("subject", "Literature")
            intent.putExtra("user", userName)
            startActivity(intent)
        }


    }

    override fun onRestart() {
        onBackPressed()
        super.onRestart()
    }

}