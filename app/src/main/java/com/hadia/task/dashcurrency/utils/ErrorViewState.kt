package com.hadia.task.dashcurrency.utils

sealed class ErrorViewState(val message: String?) {

    class Toast(message: String? = "") : ErrorViewState(message)
}
