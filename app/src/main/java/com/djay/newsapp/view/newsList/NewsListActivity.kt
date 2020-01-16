package com.djay.newsapp.view.newsList

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.espresso.idling.CountingIdlingResource
import com.djay.newsapp.BaseActivity
import com.djay.newsapp.R
import com.djay.newsapp.data.News
import com.djay.newsapp.databinding.ActivityMainBinding
import com.djay.newsapp.utils.AppConstants
import com.djay.newsapp.view.newsDetails.NewsDetailsActivity

/**
 * Activity class to present News list
 */
class NewsListActivity : BaseActivity<NewsListViewModel, ActivityMainBinding>() {

    val espressoTestIdlingResource: CountingIdlingResource = CountingIdlingResource("Network_Call")
    override val layoutRes: Int get() = R.layout.activity_main
    override fun getViewModel(): Class<NewsListViewModel>? = NewsListViewModel::class.java
    private lateinit var newsAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        espressoTestIdlingResource.increment()

        setNewsAdapter()
        viewModel?.getNews()?.observe(this, renderNews())
    }

    /**
     * Sets news adapter to the News-list
     */
    private fun setNewsAdapter() {
        newsAdapter = NewsListAdapter()
        newsAdapter.onItemClick = { article ->
            val intent = Intent(this, NewsDetailsActivity::class.java)
            intent.putExtra(AppConstants.EXTRA_ARTICLE, article)
            startActivity(intent)
        }

        dataBinding?.rvNews?.apply {
            layoutManager = LinearLayoutManager(this@NewsListActivity)
            adapter = newsAdapter
        }
    }

    /**
     * Renders News from server
     */
    private fun renderNews() = Observer<News> {
        dataBinding?.shimmerViewContainer?.stopShimmer()
        dataBinding?.shimmerViewContainer?.visibility = View.GONE
        newsAdapter.update(it.articles)
        espressoTestIdlingResource.decrement()
    }
}
