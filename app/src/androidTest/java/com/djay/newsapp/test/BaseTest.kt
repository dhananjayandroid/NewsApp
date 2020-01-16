package com.djay.newsapp.test

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.djay.newsapp.view.newsList.NewsListActivity
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.rules.TestName
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@Ignore("Base class")
open class BaseTest {

    /**
     * Provided activity will be launched before each test.
     */
    @get:Rule
    var activityTestRule = ActivityTestRule(NewsListActivity::class.java)

    /**
     * Makes the current test name available inside test methods.
     */
    @get:Rule
    var testName = TestName()

    @Before
    open fun setUp() {
        //launch(NewsListActivity::class.java)
    }
}
