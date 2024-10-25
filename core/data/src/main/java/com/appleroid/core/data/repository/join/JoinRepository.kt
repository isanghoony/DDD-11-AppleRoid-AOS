package com.appleroid.core.data.repository.join

import com.appleroid.core.network.model.join.JoinCodeVerify
import com.appleroid.core.network.model.join.JoinCodeRequest
import kotlinx.coroutines.flow.Flow

interface JoinRepository {
    fun getJoinCodeRequest(phoneNumber: String): Flow<List<JoinCodeRequest>>

    fun getJoinCodeVerify(code: String): Flow<JoinCodeVerify>
}