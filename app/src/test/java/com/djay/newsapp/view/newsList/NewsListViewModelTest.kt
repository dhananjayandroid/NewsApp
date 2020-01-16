package com.djay.newsapp.view.newsList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.djay.newsapp.data.News
import com.djay.newsapp.data.repository.NewsRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class NewsListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: NewsRepository
    lateinit var viewModel: NewsListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun fetchRepositories_positiveResponse() {
        val mutableLiveData: MutableLiveData<News> = mockThis()
        `when`(repository.getNews()).thenReturn(mutableLiveData)
        viewModel = NewsListViewModel(repository)
        Assert.assertNotNull(viewModel.getNews())
    }

    @Test
    fun fetchRepositories_negativeResponse() {
        `when`(repository.getNews()).thenReturn(null)
        viewModel = NewsListViewModel(repository)
        Assert.assertNull(viewModel.getNews())
    }

    private inline fun <reified T : Any> mockThis(): T = Mockito.mock(T::class.java)!!
}