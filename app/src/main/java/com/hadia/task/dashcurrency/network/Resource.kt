package com.hadia.task.dashcurrency.network

import com.hadia.task.dashcurrency.base.BaseViewModel
import com.hadia.task.dashcurrency.utils.ErrorViewState

data class Resource<out T>(val status: Status?, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

fun <T> Resource<T>.checkResponse(viewModel: BaseViewModel, onSuccessActionOnClick: (data: T?) -> Unit) {
    when (this.status) {
        Resource.Status.SUCCESS -> {
            viewModel.hideLoading()
            onSuccessActionOnClick.invoke(this.data)
        }
        Resource.Status.ERROR -> {
            viewModel.hideLoading()
            viewModel.setErrorState(ErrorViewState.Toast(this.message))
        }
        Resource.Status.LOADING ->
            viewModel.showLoading()
    }
}
