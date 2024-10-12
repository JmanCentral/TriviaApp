package com.arquitectura.triviapp.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arquitectura.triviapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subject = intent.getStringExtra("subject").toString()
        val correct = intent.getIntExtra("correct", 0)
        val incorrect = intent.getIntExtra("incorrect", 0)
        val currDate = intent.getStringExtra("currentDate").toString()
        val currTime = intent.getStringExtra("currentTime").toString()
        val points = intent.getIntExtra("pointScoredCurrent", 0)
        val total = intent.getIntExtra("totalPointsTillDate", 0)


        binding.subject.text = subject
        binding.correct.text = correct.toString()
        binding.incorrect.text = incorrect.toString()
        binding.date.text = currDate
        binding.time.text = currTime
        binding.earned.text = points.toString()

        binding.startAgainBtn.setOnClickListener {
            onBackPressed()
        }
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }


}