package com.djay.newsapp.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.djay.newsapp.R

class NewsDetailsScreen {

    private val newsView = onView(ViewMatchers.withId(R.id.wvNews))

    fun verifyNewsDetailsDisplayed(): NewsDetailsScreen {
        // verify the news view is visible
        newsView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }
}
