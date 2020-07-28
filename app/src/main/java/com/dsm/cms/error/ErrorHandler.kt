package com.dsm.cms.error

interface ErrorHandler {
    fun getNetworkException(throwable: Throwable)
}