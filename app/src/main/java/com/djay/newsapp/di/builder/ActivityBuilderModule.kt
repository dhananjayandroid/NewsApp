package com.djay.newsapp.di.builder

import com.djay.newsapp.view.newsDetails.NewsDetailsActivity
import com.djay.newsapp.view.newsDetails.NewsDetailsViewModel
import com.djay.newsapp.view.newsList.NewsListActivity
import com.djay.newsapp.view.newsList.NewsListViewModel
import dagger.Module

import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun newslistActivity(): NewsListActivity?

    @ContributesAndroidInjector
    abstract fun newsDetailsActivity(): NewsDetailsActivity?

    @ContributesAndroidInjector
    abstract fun contributeNewlistViewModel(): NewsListViewModel?

    @ContributesAndroidInjector
    abstract fun contributeNewsDetailsViewModel(): NewsDetailsViewModel?
}