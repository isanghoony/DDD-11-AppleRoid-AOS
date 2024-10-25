package com.appleroid.core.network.api

import com.appleroid.core.network.model.join.JoinCodeVerify
import com.appleroid.core.network.model.join.JoinCodeRequest
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface JoinApi {
    @GET("/ddd/server/joinCodeRequest")
    suspend fun getJoinCodeRequest(@Path("phoneNumber") phoneNumber: String): List<JoinCodeRequest>?

    @POST("/ddd/server/joinCodeVerify")
    suspend fun getJoinCodeVerify(@Field("code") code: String): JoinCodeVerify?
}