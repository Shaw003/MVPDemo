package com.example.mvpdemo

import com.example.mvpdemo.Common.Modules.Login.LoginPresenter
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testGetVerifyCode() {
        LoginPresenter().getVerifyCode("123", "abc")
    }
}
