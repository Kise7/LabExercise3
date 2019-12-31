package com.example.exercise3_insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCal = findViewById<Button>(R.id.buttonCalculate)

        buttonCal.setOnClickListener {
            calPayment(it)
        }

        val buttonReset = findViewById<Button>(R.id.buttonReset)

        buttonReset.setOnClickListener {
            reset(it)
        }
    }

    private fun calPayment(viewThatIsClicked: View) {
        //Age
        val spinnerAge = findViewById<Spinner>(R.id.spinnerAge)
        val age = spinnerAge.selectedItemPosition + 1
        //Gender
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val genderGroup = radioGroupGender.checkedRadioButtonId
        val radioGender = findViewById<RadioButton>(genderGroup)
        val gender = radioGender.text
        //Smoker
        val checkBoxSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        val smoker = checkBoxSmoker.isChecked
        //Calculate Premium
        var prem = 0

        if (age == 1) {
            prem += 60
        }else if (age == 2) {
            prem += 70
            if (gender == "Male") {
                prem += 50
            }
            if (smoker) {
                prem += 100
            }
        }else if (age == 3) {
            prem += 90
            if (gender == "Male")
            {
                prem += 100
            }
            if (smoker) {
                prem += 150
            }
        }else if (age == 4) {
            prem += 120
            if (gender == "Male") {
                prem += 150
            }
            if (smoker) {
                prem += 200
            }
        }else if (age == 5) {
            prem += 150
            if (gender == "Male") {
                prem += 200
            }
            if (smoker) {
                prem += 250
            }
        }else if (age == 6) {
            prem += 150
            if (gender == "Male") {
                prem += 200
            }
            if (smoker) {
                prem += 300
            }
        }
        textViewPremium.text = String.format("%s \n %s %d",getString(R.string.insurance_premium), "RM", prem)
    }

    fun reset(view: View?){
        spinnerAge.setSelection(0)
        checkBoxSmoker.isChecked = false
        radioGroupGender.clearCheck()
        textViewPremium.text = getString(R.string.insurance_premium)
    }
}
