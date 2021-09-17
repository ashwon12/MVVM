package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var mainViewModel : MainViewModel
    private val btnPlus : Button by lazy { findViewById<Button>(R.id.btn_plus)}
    private val btnMinus : Button by lazy { findViewById(R.id.btn_minus)}
    private val btnReset : Button by lazy { findViewById(R.id.btn_reset) }
    private val tvNumber : TextView by lazy { findViewById(R.id.tv_number)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewModel 객체 생성
        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        


    }

    override fun onClick(p0: View?) {

    }

}