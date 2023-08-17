package com.example.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var result = MutableLiveData<Double>(0.0)

    fun add(number1: Double,number2: Double){
        result.value = number1.plus(number2)
        Log.d("add result",result.value.toString())
    }

    fun subtraction(number1: Double,number2: Double){
        result.value = number1.minus(number2)
        Log.d("subtraction result",result.value.toString())
    }

    fun multiplication(number1: Double,number2: Double){
        result.value = number1.times(number2)
        Log.d("multiplication result",result.value.toString())
    }

    fun division(number1: Double,number2: Double){
        result.value = number1.div(number2)
        Log.d("division result",result.value.toString())
    }
}