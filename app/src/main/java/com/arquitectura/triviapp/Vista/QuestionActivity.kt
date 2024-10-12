package com.arquitectura.triviapp.Vista

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.arquitectura.triviapp.Entidades.HistoryEntity
import com.arquitectura.triviapp.Servicios.HistoryViewModel
import com.arquitectura.triviapp.Entidades.QuestionEntity
import com.arquitectura.triviapp.R
import com.arquitectura.triviapp.Servicios.QuestionViewModel
import com.arquitectura.triviapp.databinding.ActivityQuestionBinding
import java.util.*

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    private lateinit var subjectChosen: String
    private lateinit var userName: String

    private var i = 0
    private var correct = 0
    private var incorrect = 0
    private var points = 0
    private var totalPoints = 0

    private val viewModel1: HistoryViewModel by viewModels()
    private val viewModel: QuestionViewModel by viewModels()

    private var selectedOption: CardView? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra("user").toString()
        subjectChosen = intent.getStringExtra("subject").toString()

        binding.subject.text = getString(R.string.chosenSubject, subjectChosen)

        when (subjectChosen) {
            "Math" -> getMathQues()
            "Geography" -> getGeographyQues()
            "Literature" -> getLiteratureQues()
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        setupOptionClickListeners()
    }

    // Configura los listeners de los CardView
    private fun setupOptionClickListeners() {
        binding.op1.setOnClickListener { selectOption(binding.op1) }
        binding.op2.setOnClickListener { selectOption(binding.op2) }
        binding.op3.setOnClickListener { selectOption(binding.op3) }
        binding.op4.setOnClickListener { selectOption(binding.op4) }
    }

    // Marca un CardView como seleccionado
    private fun selectOption(cardView: CardView) {
        // Restablecer el estilo de las opciones no seleccionadas
        resetOptionStyles()

        // Establecer el estilo seleccionado para la opción actual
        selectedOption = cardView
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white))
    }

    // Restablece el estilo de todas las opciones
    private fun resetOptionStyles() {
        binding.op1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
        binding.op2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
        binding.op3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
        binding.op4.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cardBackground))
    }

    // Renderiza la pregunta en la pantalla
    @SuppressLint("StringFormatMatches")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun renderQuesOnScreen(question: List<QuestionEntity>, index: Int) {
        selectedOption = null // Resetea la selección al mostrar una nueva pregunta
        resetOptionStyles() // Restablece los estilos de las opciones

        if (i == 4) {
            binding.nextBtn.text = "FINISH"
        }

        if (i > 4) {
            // Aquí es donde se finaliza el cuestionario y se guarda el historial
            Toast.makeText(this, "correct = $correct, wrong $incorrect, points $points", Toast.LENGTH_SHORT).show()

            viewModel1.insert(
                HistoryEntity(
                    id = null,
                    username = userName,
                    subject = subjectChosen,
                    earned = points,
                    date = currentDate(),
                    time = currentTime()
                )
            )

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("subject", subjectChosen)
            intent.putExtra("correct", correct)
            intent.putExtra("incorrect", incorrect)
            intent.putExtra("currentDate", currentDate())
            intent.putExtra("currentTime", currentTime())
            intent.putExtra("pointScoredCurrent", points)
            intent.putExtra("totalPointsTillDate", totalPoints)

            startActivity(intent)
        } else {
            val idx = (index + 1)
            binding.questionNumber.text = getString(R.string.questionNumber, idx)
            binding.questionText.text = question[index].question
            binding.op1Text.text = question[index].op1
            binding.op2Text.text = question[index].op2
            binding.op3Text.text = question[index].op3
            binding.op4Text.text = question[index].op4

            binding.nextBtn.setOnClickListener {
                if (selectedOption != null) {
                    checkAnswer(question[index].answer)

                    Handler(Looper.getMainLooper()).postDelayed({
                        i++
                        renderQuesOnScreen(question, i)
                    }, 1000) // Espera 1 segundo antes de cargar la siguiente pregunta
                } else {
                    Toast.makeText(this, "Select an answer", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun showCorrectAnswer(correctAnswer: String) {
        // Compara la respuesta correcta con cada opción y la pinta de verde
        when (correctAnswer) {
            binding.op1Text.text.toString() -> binding.op1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
            binding.op2Text.text.toString() -> binding.op2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
            binding.op3Text.text.toString() -> binding.op3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
            binding.op4Text.toString() -> binding.op4.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
        }
    }


    // Comprueba si la opción seleccionada es la correcta
    private fun checkAnswer(correctAnswer: String) {
        val selectedText = when (selectedOption) {
            binding.op1 -> binding.op1Text.text.toString()
            binding.op2 -> binding.op2Text.text.toString()
            binding.op3 -> binding.op3Text.text.toString()
            binding.op4 -> binding.op4Text.text.toString()
            else -> ""
        }


        if (selectedText == correctAnswer) {
            correct()
        } else {
            incorrect()
            showCorrectAnswer(correctAnswer)
        }
    }

    private fun correct() {
        correct++
        points += 5
        selectedOption?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.correct_green))
    }

    private fun incorrect() {
        incorrect++
        points -= 2
        selectedOption?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.incorrect_red))
    }
    //get all question of particular subject
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getMathQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("math")
        renderQuesOnScreen(l, 0)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLiteratureQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("literature")
        renderQuesOnScreen(l, 0)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getGeographyQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("geography")
        renderQuesOnScreen(l, 0)
    }

    //    get current date
    @RequiresApi(Build.VERSION_CODES.N)
    private fun currentDate(): String {
        return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
    }

    // get current time
    @RequiresApi(Build.VERSION_CODES.N)
    private fun currentTime(): String {
        return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    override fun onRestart() {
        onBackPressed()
        super.onRestart()
    }


}