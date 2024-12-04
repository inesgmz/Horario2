package com.example.Horario2

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.horario2.R

class ViewScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_schedule)

        supportActionBar?.title = "Mi Horario - Ver Horario"


        val spinnerDays: Spinner = findViewById(R.id.spinnerDays)
        val btnCheckSchedule: Button = findViewById(R.id.btnCheckSchedule)
        val tvSchedule: TextView = findViewById(R.id.tvSchedule)

        val days = resources.getStringArray(R.array.days_of_week)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDays.adapter = adapter

        btnCheckSchedule.setOnClickListener {
            val selectedDay = spinnerDays.selectedItem.toString()
            val schedule = getScheduleForDay(selectedDay)
            tvSchedule.text = schedule
        }
    }

    private fun getScheduleForDay(dayOfWeek: String): String {
        val sharedPreferences = getSharedPreferences("SchedulePrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString(dayOfWeek, "No hay clases programadas") ?: "No hay clases programadas"
    }
}