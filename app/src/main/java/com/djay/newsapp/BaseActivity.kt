package com.djay.newsapp

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Base Activity class
 */
abstract class BaseActivity<V : ViewModel, D : ViewDataBinding?> : AppCompatActivity() {

    var dataBinding: D? = null
    var viewModel: V? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun getViewModel(): Class<V>?

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView<D>(this , layoutRes)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel() as Class<V>)
    }
}