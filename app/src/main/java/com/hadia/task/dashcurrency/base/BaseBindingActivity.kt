package com.hadia.task.dashcurrency.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.hadia.task.dashcurrency.R
import com.hadia.task.dashcurrency.utils.ErrorViewState
import com.mohamedabulgasem.loadingoverlay.LoadingAnimation
import com.mohamedabulgasem.loadingoverlay.LoadingOverlay

abstract class BaseBindingActivity <Binding : ViewDataBinding> : AppCompatActivity() {

    protected abstract val viewModel: BaseViewModel

    protected lateinit var binding: Binding

    abstract fun onViewBound(binding: Binding)

    @LayoutRes
    abstract fun getLayoutResId(): Int

    private val loadingView by lazy {
        LoadingOverlay.with(this, LoadingAnimation.LOADING_SPINNER)
    }

    protected open fun inflateContentView(): View {
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutResId(), null, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(inflateContentView())
        onViewBound(binding)
        observeOnErrorState()
    }

    private fun setupLoadingView() {
        viewModel.loadingState.observe(
            this,
            {
                if (it)
                    loadingView.show()
                else
                    loadingView.dismiss()
            }
        )
    }

    private fun observeOnErrorState() {
        viewModel.errorViewState.observe(
            this,
            {
                when (it) {
                    is ErrorViewState.Toast -> {
                        Snackbar.make(
                            binding.root,
                            it.message ?: getString(R.string.empty_state_view_error_title),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        )
    }
}
