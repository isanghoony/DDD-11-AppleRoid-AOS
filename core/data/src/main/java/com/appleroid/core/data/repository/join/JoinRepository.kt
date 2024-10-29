package com.appleroid.core.data.repository.join

import com.appleroid.core.network.model.MkResponse
import com.appleroid.core.network.model.join.JoinCodeVerify
import kotlinx.coroutines.flow.Flow

interface JoinRepository {
    fun requestJoinCode(phoneNumber: String): Flow<MkResponse<String>>?
    fun getJoinCodeVerify(code: String): Flow<JoinCodeVerify>
}