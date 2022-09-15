package com.example.med_lab3_kotlin

import android.text.Editable
import android.text.TextWatcher
import android.util.Log

class TextWatcherImpl : TextWatcher {

    val stringWorker: StringWorker = StringWorker("")

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Log.e("textWatcher","Вызван onTextChanged")
    }

    override fun afterTextChanged(s: Editable?) {
        TODO("Not yet implemented")
    }
}