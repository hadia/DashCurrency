package com.hadia.task.dashcurrency.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadia.task.dashcurrency.utils.ErrorViewState
import com.hadia.task.dashcurrency.utils.SingleLiveEvent

open class BaseViewModel : ViewModel() {
    private val _loadingState: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    private val _errorViewState: SingleLiveEvent<ErrorViewState> = SingleLiveEvent()
    val errorViewState: LiveData<ErrorViewState>
        get() = _errorViewState

    fun setErrorState(errorState: ErrorViewState) {
        _errorViewState.postValue(errorState)
    }

    fun showLoading() {
        _loadingState.postValue(true)
    }

    fun hideLoading() {
        _loadingState.postValue(false)
    }
}
