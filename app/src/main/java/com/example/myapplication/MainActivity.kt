package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    companion object{
        const val TAG : String = "로그"
    }

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

        //LiveData(number)에 ViewModel 연결
        mainViewModel.number.observe(this, Observer {
            Log.d(TAG, "viewModel의 number 관찰중... : $it")
            tvNumber.text = it.toString()
        })

    }

    override fun onClick(p0: View?) {

    }

}