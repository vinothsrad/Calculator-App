package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        val input=findViewById<TextView>(R.id.input)
        val output=findViewById<TextView>(R.id.output)
        val clearBtn=findViewById<AppCompatButton>(R.id.button_clear)
        val bracketBtn=findViewById<AppCompatButton>(R.id.button_bracket)
        val croxxBtn=findViewById<AppCompatButton>(R.id.button_croxx)
        val bracketRBtn=findViewById<AppCompatButton>(R.id.button_bracket_r)
        val zeroBtn=findViewById<AppCompatButton>(R.id.button_0)
        val oneBtn=findViewById<AppCompatButton>(R.id.button_1)
        val twoBtn=findViewById<AppCompatButton>(R.id.button_2)
        val threeBtn=findViewById<AppCompatButton>(R.id.button_3)
        val fourBtn=findViewById<AppCompatButton>(R.id.button_4)
        val fiveBtn=findViewById<AppCompatButton>(R.id.button_5)
        val sixBtn=findViewById<AppCompatButton>(R.id.button_6)
        val sevenBtn=findViewById<AppCompatButton>(R.id.button_7)
        val eightBtn=findViewById<AppCompatButton>(R.id.button_8)
        val nineBtn=findViewById<AppCompatButton>(R.id.button_9)
        val dotBtn=findViewById<AppCompatButton>(R.id.button_dot)
        val divisionBtn=findViewById<AppCompatButton>(R.id.button_division)
        val multiplyBtn=findViewById<AppCompatButton>(R.id.button_multiply)
        val additionBtn=findViewById<AppCompatButton>(R.id.button_addition)
        val equalBtn=findViewById<AppCompatButton>(R.id.button_equals)
        val subtractionBtn=findViewById<AppCompatButton>(R.id.button_subtraction)



        clearBtn.setOnClickListener {
            input.text = ""
            output.text = ""
        }


        bracketBtn.setOnClickListener {

            input.text = addToInputText("(")

        }
        bracketRBtn.setOnClickListener {

            input.text = addToInputText(")")

        }

        croxxBtn.setOnClickListener {
            val removedLast = input.text.toString().dropLast(1)
            input.text = removedLast
        }

        zeroBtn.setOnClickListener {
            input.text = addToInputText("0")
        }
        oneBtn.setOnClickListener {
            input.text = addToInputText("1")
        }
        twoBtn.setOnClickListener {
            input.text = addToInputText("2")
        }
        threeBtn.setOnClickListener {
            input.text = addToInputText("3")
        }
        fourBtn.setOnClickListener {
            input.text = addToInputText("4")
        }
        fiveBtn.setOnClickListener {
            input.text = addToInputText("5")
        }
        sixBtn.setOnClickListener {
            input.text = addToInputText("6")
        }
        sevenBtn.setOnClickListener {
            input.text = addToInputText("7")
        }
        eightBtn.setOnClickListener {
            input.text = addToInputText("8")
        }
        nineBtn.setOnClickListener {
            input.text = addToInputText("9")
        }
        dotBtn.setOnClickListener {
            input.text = addToInputText(".")
        }
        divisionBtn.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        multiplyBtn.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }

        subtractionBtn.setOnClickListener {
            input.text = addToInputText("-")
        }
        additionBtn.setOnClickListener {
            input.text = addToInputText("+")
        }

        equalBtn.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        val input=findViewById<TextView>(R.id.input)
       // val output=findViewById<TextView>(R.id.output)
        return input.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        val input=findViewById<TextView>(R.id.input)
      //  val output=findViewById<TextView>(R.id.output)
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        //val input=findViewById<TextView>(R.id.input)
        val output=findViewById<TextView>(R.id.output)
        try {
            val expression = getInputExpression()
           val result = Expression(expression).calculate()
           if (result.isNaN()) {
               // Show Error Message
                output.text = ""
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
               output.text = DecimalFormat("0.######").format(result).toString()
               output.setTextColor(ContextCompat.getColor(this, R.color.green))
           }
       } catch (e: Exception) {
            // Show Error Message
           output.text = ""
           output.setTextColor(ContextCompat.getColor(this, R.color.red))
       }
   }
}

