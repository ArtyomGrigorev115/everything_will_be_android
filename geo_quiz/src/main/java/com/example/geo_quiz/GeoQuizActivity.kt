package com.example.geo_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class GeoQuizActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    /*Image Buttons*/
    private lateinit var nextImageButton: ImageButton
    private lateinit var prevImageButton: ImageButton

    private val questionBank: List<Question> = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0
   // private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
  //  private lateinit var backButton: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_quiz2)

        /*ImageButtons objects*/
        nextImageButton = findViewById(R.id.next_button)
        prevImageButton = findViewById(R.id.back)
        /*true false buttons*/
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

       // nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
       // backButton = findViewById(R.id.back)
        textView = findViewById(R.id.question_text_view)

        textView.setOnClickListener{
            //Toast.makeText(this,"TextWiewClick",Toast.LENGTH_SHORT).show()
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
            updateQuestion()
        }

        trueButton.setOnClickListener { view: View ->
            // Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show()
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View ->
            // val t:Toast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT)
            // t.setGravity(Gravity.TOP,50,200)
            // t.show()
            checkAnswer(false)

            //  Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show()
        }

        nextImageButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
              val questionTextResId = questionBank[currentIndex].textResId
              questionTextView.setText(questionTextResId)
            updateQuestion()
        }

        prevImageButton.setOnClickListener {
           // currentIndex = kotlin.math.abs((currentIndex - 1)) % questionBank.size
            currentIndex = if(currentIndex - 1 >=0) currentIndex -1 else questionBank.lastIndex
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
            updateQuestion()
        };

        // val questionTextResId = questionBank[currentIndex].textResId
        // questionTextView.setText(questionTextResId)
        updateQuestion()


    }


    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }

}