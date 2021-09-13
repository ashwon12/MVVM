package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface MainViewModel {
    val a: LiveData<Int>
    val b: LiveData<ArrayList<String>>

    fun plusNumber()
    fun printNumber(): String
    fun onLifeCycle(state: String)
}

class MainViewModelImpl(val name: String) : MainViewModel, ViewModel() {
    private val _a: MutableLiveData<Int> = MutableLiveData(0)
    override val a: LiveData<Int>
        get() = _a

    private val _b: MutableLiveData<ArrayList<String>> = MutableLiveData(ArrayList())
    override val b: LiveData<ArrayList<String>>
        get() = _b

    override fun plusNumber() {
        _a.value = (a.value ?: 0) + 1
        Log.d("ehdghks", "plustNumber : ${_a.value}")
    }

    override fun printNumber(): String {
        return (a.value ?: 0).toString()
    }

    override fun onLifeCycle(state: String) {
        val temp = b.value
        temp?.add(state)
        _b.value = temp
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ehdghks", "onCleared : ${_a.value}")
    }
}