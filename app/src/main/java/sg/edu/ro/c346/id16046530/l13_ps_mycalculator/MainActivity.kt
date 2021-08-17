package sg.edu.ro.c346.id16046530.l13_ps_mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNew = true

    var oldNumber = ""
    var operator = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numOnClick(view: View) {
        if(isNew)
            tvNumber.setText("")
        isNew = false
        var number =  tvNumber.text.toString()
        var buttonSelected = view as Button
        when(buttonSelected.id) {
            btn1.id -> number += "1"
            btn2.id -> number += "2"
            btn3.id -> number += "3"
            btn4.id -> number += "4"
            btn5.id -> number += "5"
            btn6.id -> number += "6"
            btn7.id -> number += "7"
            btn8.id -> number += "8"
            btn9.id -> number += "9"
            btn0.id -> number += "0"
            btnDot.id -> number += "."
            btnPlusMinus.id -> number = "-$number"
        }
        tvNumber.setText(number)
    }
    fun operatorEvent(view: View) {
        isNew = true
        oldNumber = tvNumber.text.toString()
        var buttonSelected = view as Button
        when(buttonSelected.id) {
            btnMultiply.id -> operator = "*"
            btnPlus.id -> operator = "+"
            btnMinus.id -> operator = "-"
            btnDivide.id -> operator = "/"
        }
    }
    fun equalEvent(view: View) {
        var newNumber = tvNumber.text.toString()
        var result = 0.0
        if(isNew) {
            }
        else {
            when (operator) {
                "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
                "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
                "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
                "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
            }
            tvNumber.setText(result.toString())
        }
    }

    fun acEvent(view: View){
        tvNumber.setText("0")
        isNew = true
    }

    fun onPercent(view: View) {
        var num = tvNumber.text.toString().toDouble()/100
        tvNumber.setText(num.toString())

    }
    fun onPlusMinus(view: View) {

    }

}
