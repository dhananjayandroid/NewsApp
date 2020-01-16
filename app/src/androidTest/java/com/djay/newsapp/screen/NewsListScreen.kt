package com.djay.newsapp.screen


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.djay.newsapp.R

class NewsListScreen {

    private val newsListRecyclerView = onView(ViewMatchers.withId(R.id.rvNews))

    fun clickNewsListItem(): NewsDetailsScreen {
        newsListRecyclerView.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        return NewsDetailsScreen()
    }

    fun verifyNewsListIsVisible(): NewsListScreen {
        // Verify news list is Visible
        newsListRecyclerView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return NewsListScreen()
    }
}