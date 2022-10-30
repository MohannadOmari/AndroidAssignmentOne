package com.codecademy.assignmentone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.DeadObjectException
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.resultBtn)
        val numOne:EditText = findViewById(R.id.numOne)
        val numTwo:EditText = findViewById(R.id.numTwo)
        val result:TextView = findViewById(R.id.resultView)
        var flag:String = "sum"
        val calculations:Spinner = findViewById(R.id.calculations)
        var options = arrayOf("sum", "subtract", "multiply", "divide")
        calculations.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        button.setOnClickListener { view ->
            var x: Double = numOne.text.toString().toDouble()
            var y: Double = numTwo.text.toString().toDouble()
            result.text = calculate(x, y, flag).toString()

        }
        calculations.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}

public fun calculate(x:Double, y:Double, choice:String):Double {
    when (choice) {
        "sum" -> {
            return x + y
        }
        "subtract" -> {
            return x - y
        }
        "multiply" -> {
            return x * y
        }
        "divide" -> {
            return x / y
        }
        else -> return 0.00
    }
}



