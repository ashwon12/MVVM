package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btn1).apply {
            this.setOnClickListener {
                btnClick()
            }
        }

        tv = findViewById(R.id.tv)

        mainViewModel.b.observe(this) { list ->
            tv.text = list?.joinToString {
                it + "\n"
            }
        }
    }

    private fun btnClick() {
        mainViewModel.plusNumber()
        Toast.makeText(applicationContext, mainViewModel.printNumber(), Toast.LENGTH_SHORT).show()
    }
}