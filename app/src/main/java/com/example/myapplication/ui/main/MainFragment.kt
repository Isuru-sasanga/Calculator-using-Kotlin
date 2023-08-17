package com.example.myapplication.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.media.VolumeShaper.Operation
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        var answer = view.findViewById<TextView>(R.id.results)
        if (answer != null){
            answer.text = "Answer" + viewModel.result.value.toString()
        }
        viewModel.result.observe(viewLifecycleOwner, Observer {
            answer.text = it.toString()
        })

        var editTextN1 = view.findViewById<EditText>(R.id.number1)
        var editTextN2 = view.findViewById<EditText>(R.id.number2)
        var addButton = view.findViewById<Button>(R.id.addButton)
        var subButton = view.findViewById<Button>(R.id.subtractionButton)
        var divButton = view.findViewById<Button>(R.id.divisionButton)
        var multiButton = view.findViewById<Button>(R.id.multiplicationButton)



        fun allOperations(operation: (Double, Double) -> Unit) {
            val number1S = editTextN1?.text.toString()
            val number1 = number1S?.toDoubleOrNull()
            val number2S = editTextN2?.text.toString()
            val number2 = number2S?.toDoubleOrNull()

            if ((number1 != null) && (number2 != null)) {
                operation(number1, number2)
            }
        }
        
        var clean = view.findViewById<Button>(R.id.clean)
        clean.setOnClickListener {
            editTextN1.setText("")
            editTextN2.setText("")
            answer.text = ""
        }

        addButton.setOnClickListener{
            allOperations { number1, number2 -> viewModel.add(number1, number2) }
        }

        subButton.setOnClickListener {
            allOperations { number1, number2 -> viewModel.subtraction(number1, number2) }
        }

        divButton.setOnClickListener {
            allOperations { number1, number2 -> viewModel.division(number1, number2) }
        }

       multiButton.setOnClickListener {
           allOperations { number1, number2 -> viewModel.multiplication(number1, number2) }
        }




        return view
    }

}