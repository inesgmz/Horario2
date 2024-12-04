package com.example.Horario2

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.horario2.R

class AddClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_class)

        supportActionBar?.title = "Mi Horario - Añadir Clase"

        val etClassName: EditText = findViewById(R.id.etClassName)
        val spinnerDayOfWeek: Spinner = findViewById(R.id.spinnerDayOfWeek)
        val timePicker: TimePicker = findViewById(R.id.timePicker)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnCancel: Button = findViewById(R.id.btnCancel)


        val daysOfWeek = resources.getStringArray(R.array.days_of_week)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daysOfWeek)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDayOfWeek.adapter = adapter

        btnAdd.setOnClickListener {
            val className = etClassName.text.toString()
            val dayOfWeek = spinnerDayOfWeek.selectedItem.toString()
            val hour = timePicker.hour
            val minute = timePicker.minute


            val sharedPreferences = getSharedPreferences("SchedulePrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val schedule = "$className a las $hour:$minute"
            editor.putString(dayOfWeek, schedule)
            editor.apply()

            finish()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }
}