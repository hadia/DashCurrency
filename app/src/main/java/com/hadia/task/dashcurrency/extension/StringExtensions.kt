package com.hadia.task.dashcurrency.extension

fun String.toFormattedNumberString(): String {
    return String.format("%.2f", this.toDoubleOrNull() ?: 0)
}
