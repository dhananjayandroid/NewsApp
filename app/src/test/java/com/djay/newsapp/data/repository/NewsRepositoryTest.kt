package com.djay.newsapp.data.repository

import com.djay.newsapp.data.News
import com.djay.newsapp.data.remote.ApiService
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Call


class NewsRepositoryTest {
    private lateinit var repository: NewsRepository

    @Mock
    lateinit var apiService: ApiService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = Mockito.spy(NewsRepository(apiService))
    }

    @Test
    fun getMoviesList() {

        val call: Call<News> = mockThis()
        Mockito.`when`(apiService.loadNews(anyString(), anyString())).thenReturn(call)
        // trigger
        repository.getNews()
        // validation
        Mockito.verify(apiService, Mockito.times(1)).loadNews(anyString(), anyString())
    }

    private inline fun <reified T : Any> mockThis(): T = Mockito.mock(T::class.java)!!
}

