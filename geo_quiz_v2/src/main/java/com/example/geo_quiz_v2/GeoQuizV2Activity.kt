package com.example.geo_quiz_v2

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

private const val TAG = "GeoQuizV2Activity"
private const val KEY_INDEX = "index"
class GeoQuizV2Activity : AppCompatActivity() {

    private val questionBank: List<QuestionV2> = listOf(
        QuestionV2(R.string.question_australia, true),
        QuestionV2(R.string.question_oceans, true),
        QuestionV2(R.string.question_mideast, false),
        QuestionV2(R.string.question_africa, false),
        QuestionV2(R.string.question_americas, true),
        QuestionV2(R.string.question_asia, true)
    )
    private var currentIndex = 0

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    /*Image Buttons*/
    private lateinit var nextImageButton: ImageButton
    private lateinit var prevImageButton: ImageButton


    private lateinit var questionTextView: TextView

    private lateinit var textView: TextView

   // var currentInstanceIndex: Bundle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_quiz_v2)

       // currentInstanceIndex= savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0

        Log.d(TAG, "onCreate(Bundle?) called")

        /*ImageButtons objects*/
        nextImageButton = findViewById(R.id.next_button)
        prevImageButton = findViewById(R.id.back)
        /*true false buttons*/
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        questionTextView = findViewById(R.id.question_text_view)

        textView = findViewById(R.id.question_text_view)

        textView.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
            updateQuestion()
        }

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
            if(questionTextView.text == resources.getString(questionBank[currentIndex].textResId)){
                Log.d("ResGet", "Одинаковый вопрос")
            }
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
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

        updateQuestion()


    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)

       /* if (questionBank[currentIndex].answer == false) {
            trueButton.setEnabled(true);
            falseButton.setEnabled(true);
        }else {
            trueButton.setEnabled(false);
            falseButton.setEnabled(false);
        }*/
       // trueButton.setEnabled(questionBank[currentIndex].answer);
       // trueButton.isEnabled = false;

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

        if(userAnswer == correctAnswer){
              trueButton.setEnabled(false);
              falseButton.setEnabled(false);
        }
      //  trueButton.setEnabled(false);
      //  falseButton.setEnabled(false);
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState")

    }
}