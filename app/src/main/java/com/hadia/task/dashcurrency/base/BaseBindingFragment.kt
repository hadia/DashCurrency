package com.hadia.task.dashcurrency.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.hadia.task.dashcurrency.R
import com.hadia.task.dashcurrency.utils.ErrorViewState
import com.mohamedabulgasem.loadingoverlay.LoadingAnimation
import com.mohamedabulgasem.loadingoverlay.LoadingOverlay

abstract class BaseBindingFragment<Binding : ViewDataBinding> : Fragment() {
    protected abstract val viewModel: BaseViewModel

    protected lateinit var binding: Binding

    abstract fun onViewBound(binding: Binding)

    @LayoutRes
    abstract fun getLayoutResId(): Int

    private val loadingView by lazy {
        LoadingOverlay.with(requireActivity(), LoadingAnimation.LOADING_SPINNER)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onViewBound(binding)
        observeOnErrorState()
    }

    private fun setupLoadingView() {
        viewModel.loadingState.observe(
            viewLifecycleOwner,
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
            viewLifecycleOwner,
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
