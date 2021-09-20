package com.walter.pokedata.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Test
    fun checkInputtedValues() {
        login {
            launch()
            inputLogin("walter@teste.com")
            inputMatchText("walter@teste.com")
        }
    }
}
