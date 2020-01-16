package com.djay.newsapp.data.remote

import com.djay.newsapp.data.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface for web-apis
 */
interface ApiService {

    /**
     * Load news from server
     * @param country: country code
     * @param key: api key fro newsapi.org
     */
    @GET("top-headlines")
    fun loadNews(@Query("country") country: String, @Query("apiKey") key: String): Call<News>
}