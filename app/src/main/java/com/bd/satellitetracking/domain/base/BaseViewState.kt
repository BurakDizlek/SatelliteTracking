package com.bd.satellitetracking.domain.base

sealed class BaseViewState<out T> {
    object Loading : BaseViewState<Nothing>()
    data class DataReady<T>(val data: T) : BaseViewState<T>()
    data class NoData(val message: String) : BaseViewState<Nothing>()
    data class Error(val message: String) : BaseViewState<Nothing>()
}