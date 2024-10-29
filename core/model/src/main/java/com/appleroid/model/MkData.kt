package com.appleroid.model

data class MkData<T>(
    val status: String,
    val statusCode: Int,
    val message: String,
    val data: T
)