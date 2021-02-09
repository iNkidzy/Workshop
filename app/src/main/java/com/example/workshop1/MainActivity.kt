package com.example.workshop1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayout = findViewById(R.id.linearLayout) as LinearLayout

        //Change View
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = setContentView(R.layout.second)
            startActivity(intent)




         /*  val textView = TextView(this)

           linearLayout.addView(textView)

            val datePicker = DatePicker(this)
            textView.text = "Year: "+datePicker.year+ " Month: "+ (datePicker.month+1) +" Day: "+ datePicker.dayOfMonth

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()

            datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                    DatePicker.OnDateChangedListener { datePicker, year, month, day->
                        textView.text = "Year: "+ year + " Month: "+ (month+1) + " Day: "+day
                    })
            linearLayout.addView(datePicker)
         */

        }

    }

    private fun startActivity(intent: Unit) {
        setContentView(R.layout.second)
        //DatePicker
        val datePicker = findViewById<DatePicker>(R.id.date_Picker)
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))

        { view, year, month, day ->
            val month = month + 1
            val msg = "You selected: $day/$month/$year"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()

        }
    }

    fun selctDate(view: View) {


    }
}