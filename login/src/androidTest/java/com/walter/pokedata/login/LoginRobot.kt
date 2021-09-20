package com.walter.pokedata.login

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.walter.pokedata.login.presentation.LoginFragment


class LoginRobot {
    fun launch() = launchFragmentInContainer<LoginFragment>()
    fun inputLogin(login: String) = onView(withId(R.id.login_input)).perform(typeText(login))
    fun inputMatchText(text: String) =
        onView(withId(R.id.login_input)).check(matches(withText(text)))
}

fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply { }