package com.appleroid.core.data.repository.join

import com.appleroid.core.network.api.JoinApi
import com.appleroid.core.network.model.join.JoinCodeRequest
import com.appleroid.core.network.model.join.JoinCodeVerify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

internal class JoinPhoneNumberVerifyRepository @Inject constructor(
    val joinApi: JoinApi
) : JoinRepository {
    override fun getJoinCodeRequest(phoneNumber: String): Flow<List<JoinCodeRequest>> = flow {
        val joinCodeRequest = joinApi.getJoinCodeRequest(phoneNumber)
        joinCodeRequest?.let { data ->
            emit(data)
        } ?: emit(emptyList())
    }

    override fun getJoinCodeVerify(code: String): Flow<JoinCodeVerify> = flow {
        joinApi.getJoinCodeVerify(code)?.let {
            emit(it)
        }
    }
}