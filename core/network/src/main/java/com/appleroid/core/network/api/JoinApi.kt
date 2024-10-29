package com.appleroid.core.network.api

import com.appleroid.core.network.model.MkResponse
import com.appleroid.core.network.model.join.JoinCodeVerify
import retrofit2.http.Field
import retrofit2.http.POST

interface JoinApi {
    /**
     * 전화번호 인증 요청 API
     * */
    @POST("/passport/request/phone/auth")
    suspend fun requestJoinCode(@Field("phoneNumber") phoneNumber: String): MkResponse<String>?

    @POST("/ddd/server/joinCodeVerify")
    suspend fun getJoinCodeVerify(@Field("code") code: String): JoinCodeVerify?
}