package com.example.Horario2

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.horario2.R
import java.text.SimpleDateFormat
import java.util.*

class CurrentClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_class)

        supportActionBar?.title = "Mi Horario - ¿Que toca ahora?"


        val tvDateTime: TextView = findViewById(R.id.tvDateTime)
        val tvCurrentClass: TextView = findViewById(R.id.tvCurrentClass)
        val btnBack: Button = findViewById(R.id.btnBack)

        val currentDateTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, MMMM d, HH:mm", Locale("es", "ES"))
        val formattedDateTime = dateFormat.format(currentDateTime)


        val sharedPreferences = getSharedPreferences("SchedulePrefs", Context.MODE_PRIVATE)
        val className = sharedPreferences.getString("className", "No hay clase")
        val dayOfWeek = sharedPreferences.getString("dayOfWeek", "")
        val hour = sharedPreferences.getInt("hour", 0)
        val minute = sharedPreferences.getInt("minute", 0)


        val currentDayOfWeek = SimpleDateFormat("EEEE", Locale("es", "ES")).format(currentDateTime)
        val currentClass = if (currentDayOfWeek == dayOfWeek) {
            "$className a las $hour:$minute"
        } else {
            "No hay clase"
        }

        tvDateTime.text = formattedDateTime
        tvCurrentClass.text = "Clase Actual: $currentClass"

        btnBack.setOnClickListener {
            finish()
        }
    }
}