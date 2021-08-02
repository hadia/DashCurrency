package com.hadia.task.dashcurrency.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingActivity <Binding : ViewDataBinding> : AppCompatActivity() {

    protected abstract val viewModel: BaseViewModel

    protected lateinit var binding: Binding

    abstract fun onViewBound(binding: Binding)

    @LayoutRes
    abstract fun getLayoutResId(): Int

    protected open fun inflateContentView(): View {
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutResId(), null, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(inflateContentView())
        onViewBound(binding)
    }
}
