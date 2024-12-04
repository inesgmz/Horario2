package com.example.Horario2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.horario2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Mi Horario"


        val btnAddClass: Button = findViewById(R.id.btnAddClass)
        val btnViewSchedule: Button = findViewById(R.id.btnViewSchedule)
        val btnCurrentClass: Button = findViewById(R.id.btnCurrentClass)

        btnAddClass.setOnClickListener {
            startActivity(Intent(this, AddClassActivity::class.java))
        }
        btnViewSchedule.setOnClickListener {
            startActivity(Intent(this, ViewScheduleActivity::class.java))
        }
        btnCurrentClass.setOnClickListener {
            startActivity(Intent(this, CurrentClassActivity::class.java))
        }
    }
}