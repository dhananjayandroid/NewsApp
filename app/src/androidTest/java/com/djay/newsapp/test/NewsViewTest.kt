package com.djay.newsapp.test

import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.idling.CountingIdlingResource
import androidx.test.filters.LargeTest
import com.djay.newsapp.screen.NewsListScreen
import org.junit.Test


@LargeTest
class NewsViewTest : BaseTest() {

    @Test
    fun verifyNewsViewDisplay() {
        val mainActivityIdlingResource: CountingIdlingResource =
            activityTestRule.activity.espressoTestIdlingResource

        IdlingRegistry.getInstance().register(mainActivityIdlingResource)

        NewsListScreen()
            .verifyNewsListIsVisible()
            .clickNewsListItem()
            .verifyNewsDetailsDisplayed()

        IdlingRegistry.getInstance().unregister(mainActivityIdlingResource)
    }

}