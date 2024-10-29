package com.appleroid.core.network.model.join

data class JoinCodeRequest (
    val status: String,
    val statusCode: Int,
    val message: String,
    val data: String
)