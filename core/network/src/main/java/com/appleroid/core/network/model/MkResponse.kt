package com.appleroid.core.network.model

data class MkResponse<T>(
    val status: String,
    val statusCode: Int,
    val message: String,
    val data: T
)