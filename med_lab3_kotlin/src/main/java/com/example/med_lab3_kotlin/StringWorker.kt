package com.example.med_lab3_kotlin

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
        for(i: Int in str.indices step 1){
            if(str[i].isLetter()){
                if(str[i] !in 'a'..'z' && str[i] !in 'A'..'Z' ){
                    println("русская буква ${str[i]}")
                    counter++
                }
            }
        }
        return this.counter;
    }
}