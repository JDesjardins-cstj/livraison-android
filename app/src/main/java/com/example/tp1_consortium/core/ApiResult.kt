package com.example.tp1_consortium.core

sealed class ApiResult<out Z> {
    data class Success<Z>(val data:Z) : ApiResult<Z>()
    data class Error(val throwable: Throwable) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}