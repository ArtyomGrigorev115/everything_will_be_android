package com.example.med_lab3v2_kotlin

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView

class TextWatcherImpl  constructor(): TextWatcher {

    val stringWorker: StringWorker = StringWorker("")
    lateinit var textView: TextView;
    constructor(view: View) : this(){
        this.textView = view as TextView
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        stringWorker.setString(s.toString())

        Log.e("textWatcher","Вызван onTextChanged + ${s.toString()}")
        Log.e("textWatcher","Число русских букв: ${stringWorker.quantityNotLatinLetters()}")
        Log.e("textWatcher","Параметр start: ${start.toString()}")
        Log.e("textWatcher","Параметр before: ${before.toString()}")
        Log.e("textWatcher","Параметр count: ${count.toString()}")

        val text: CharSequence = textView.text
        val counterRussianLetter: Int = stringWorker.quantityNotLatinLetters()
        val s = text.toString() + counterRussianLetter.toString()

       // Log.e("textWatcher","Русские буквы: ${s.replace(s.last().toString(),counterRussianLetter.toString())}")

        textView.text = s
    }

    override fun afterTextChanged(s: Editable?) {

    }
}