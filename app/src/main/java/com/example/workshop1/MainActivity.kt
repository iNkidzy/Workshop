package com.example.workshop1

import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Change View
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = setContentView(R.layout.second)
            startActivity(intent)
        }

    }

    // MainActivity.kt for second.xml
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

        val pickTimeBtn = findViewById<Button>(R.id.pickTimeBtn)
        val timeTV = findViewById<TextView>(R.id.timeTV)

        pickTimeBtn.setOnClickListener{
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener{timePicker:TimePicker, hour:Int, minute: Int ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                //time to textview
                timeTV.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

        }

        //GoBackButton
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener{
            val intents= setContentView(R.layout.activity_main)
            backActivity(intents)
        }

    }


    private fun backActivity(intents: Unit) {
        setContentView(R.layout.activity_main)
    }

}