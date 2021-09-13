package com.example.myapplication

import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun before() {
        mainViewModel = MainViewModelImpl()
    }

    @After
    fun after() {

    }

    @Test
    fun `숫자 상승 테스트`() {
        //given

        //when
        mainViewModel.plusNumber()
        mainViewModel.plusNumber()

        //then
        assertEquals("2", mainViewModel.printNumber())
    }

}