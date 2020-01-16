package com.djay.newsapp.di.component

import android.app.Application
import com.djay.newsapp.NewsApp
import com.djay.newsapp.di.builder.ActivityBuilderModule
import com.djay.newsapp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, ActivityBuilderModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?

        fun build(): AppComponent?
    }

    fun inject(newsApp: NewsApp?)
}