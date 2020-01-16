package com.djay.newsapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.djay.newsapp.ViewModelFactory
import com.djay.newsapp.view.newsDetails.NewsDetailsViewModel
import com.djay.newsapp.view.newsList.NewsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    internal abstract fun bindsNewsistViewModel(newsListViewModel: NewsListViewModel?): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailsViewModel::class)
    abstract fun bindsNewsDetailsViewModel(newsDetailsViewModel: NewsDetailsViewModel?): ViewModel?

    @Binds
    internal abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory?): ViewModelProvider.Factory
}