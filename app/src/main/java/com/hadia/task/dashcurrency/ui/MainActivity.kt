package com.hadia.task.dashcurrency.ui

import com.hadia.task.dashcurrency.R
import com.hadia.task.dashcurrency.base.BaseBindingActivity
import com.hadia.task.dashcurrency.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun onViewBound(binding: ActivityMainBinding) {
    }
}
