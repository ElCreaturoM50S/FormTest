package com.example.formtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var et: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.spinnertestowy,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val et: EditText = findViewById(R.id.duzo)
        val bs: Button = findViewById(R.id.buttonSend)

        val rege = Regex("^[test].+")

        bs.setOnClickListener{
            if (rege.matches(et.text)) {
                Toast.makeText(this, et.text, Toast.LENGTH_SHORT).show()
            }
        }

    }
}