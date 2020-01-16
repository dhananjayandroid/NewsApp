package com.djay.newsapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.djay.newsapp.data.News
import com.djay.newsapp.data.remote.ApiService
import com.djay.newsapp.utils.AppConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Repository class to provide top news list
 */
class NewsRepository @Inject constructor(private val service: ApiService) {

    /**
     * Calls web-api and retrieve top news
     */
    fun getNews(): MutableLiveData<News> {
        val newsData: MutableLiveData<News> = MutableLiveData()
        service.loadNews(AppConstants.COUNTRY, AppConstants.APP_KEY)
            .enqueue(object : Callback<News?> {
                override fun onResponse(call: Call<News?>?, response: Response<News?>) {
                    if (response.isSuccessful)
                        newsData.value = response.body()
                }

                override fun onFailure(call: Call<News?>?, t: Throwable?) {
                    newsData.value = null
                }
            })
        return newsData
    }

}
