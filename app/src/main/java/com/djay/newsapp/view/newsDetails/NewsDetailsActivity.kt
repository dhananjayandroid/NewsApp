package com.djay.newsapp.view.newsDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.djay.newsapp.BaseActivity
import com.djay.newsapp.R
import com.djay.newsapp.data.Article
import com.djay.newsapp.databinding.ActivityNewsDetailsBinding
import com.djay.newsapp.utils.AppConstants

/**
 * Activity class to present News into WebView
 */
class NewsDetailsActivity : BaseActivity<NewsDetailsViewModel, ActivityNewsDetailsBinding>() {

    override val layoutRes: Int get() = R.layout.activity_news_details
    override fun getViewModel(): Class<NewsDetailsViewModel>? = NewsDetailsViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        loadUrlIntoWebView()
    }

    /**
     * loads selected article into WebView
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun loadUrlIntoWebView() {
        val article: Article = intent.getSerializableExtra(AppConstants.EXTRA_ARTICLE) as Article
        val webView: WebView? = dataBinding?.wvNews
        webView?.apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            loadUrl(article.url)
        }
    }

    /**
     * Custom WebViewClient to load url
     */
    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}
