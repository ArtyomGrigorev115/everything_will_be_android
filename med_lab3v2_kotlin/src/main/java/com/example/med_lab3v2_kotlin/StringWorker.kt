package com.example.med_lab3v2_kotlin

import androidx.annotation.NonNull

class StringWorker constructor(@NonNull str: String) {
    private var str: String
    private var counter: Int =0;
    init{
        this.str = str
    }

    fun getString():String = this.str
    fun setString(@NonNull str: String):Unit{
        this.str = str
    }

    fun quantityNotLatinLetters(): Int{
        var russianLetters: Int =0
        for(i: Int in str.indices step 1){
            if(str[i].isLetter()){
                if(str[i] !in 'a'..'z' && str[i] !in 'A'..'Z' ){
                    println("русская буква ${str[i]}")
                    russianLetters++
                }
            }
        }
        return russianLetters
    }

    fun quantityNotLatinLetters2(sequence: CharSequence?, before:Int): Int{
        var russianLetters: Int =0
        if(sequence?.get(before)!!.isLetter()){
            if(sequence[before] !in 'a'..'z' && sequence[before] !in 'A'..'Z' ){

                russianLetters++
            }
        }
        return russianLetters
    }
}