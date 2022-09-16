package com.example.med_lab3v2_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView

class Lab3v2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3v2)

        val textView: TextView = findViewById<TextView>(R.id.output)

        val editText: EditText = findViewById<EditText>(R.id.input)
        val textWatcher2: TextWatcherImpl = TextWatcherImpl(textView)

        /* val textWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                Log.e("textWatcher","Вызван onTextChanged")
            }

            override fun afterTextChanged(s: Editable) {}
        }*/

        editText.addTextChangedListener(textWatcher2)
    }
}