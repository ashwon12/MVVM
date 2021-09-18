package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface MainViewModelImpl {
    val number: LiveData<Int>

    fun plusNumber()
    fun minusNumber()
    fun resetNumber()
}

class MainViewModel() : MainViewModelImpl, ViewModel() {

    companion object{
        const val TAG : String = "MainViewModel"
    }

    private val _number: MutableLiveData<Int> = MutableLiveData(0) // 내부에서 사용하는 값
    override val number: LiveData<Int>
        get() = _number


    override fun plusNumber() {
        _number.value = _number.value?.plus(1)
        Log.d(TAG, "plus number : ${_number.value}")
    }

    override fun minusNumber() {
        _number.value = _number.value?.minus(1)
        Log.d(TAG, "minus number : ${_number.value}")
    }

    override fun resetNumber() {
        _number.value = 0
        Log.d(TAG, "number reset!!!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel End")
    }
}