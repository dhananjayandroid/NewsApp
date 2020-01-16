package com.djay.newsapp

import android.app.Application
import com.djay.newsapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Application class
 */
class NewsApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
        setInstance(this)
    }

    /**
     * Initialize Dagger for dependency injection
     */
    private fun initializeComponent() {
        DaggerAppComponent.builder()
            .application(this)
            ?.build()
            ?.inject(this)
    }

    companion object {
        var appContext: NewsApp? = null
            private set

        @Synchronized
        private fun setInstance(app: NewsApp) {
            appContext = app
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}