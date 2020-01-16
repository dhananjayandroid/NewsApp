package com.djay.newsapp.view.newsList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.djay.newsapp.data.News
import com.djay.newsapp.data.repository.NewsRepository
import javax.inject.Inject

/**
 * ViewModel class to retrieve new list
 */
class NewsListViewModel @Inject constructor(articleRepository: NewsRepository) : ViewModel() {
    // MutableLiveData for news data
    private val news: MutableLiveData<News> = articleRepository.getNews()

    fun getNews(): MutableLiveData<News> {
        return news
    }
}