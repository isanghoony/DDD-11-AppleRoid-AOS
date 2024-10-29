package com.appleroid.core.data.repository.join

import com.appleroid.core.network.api.JoinApi
import com.appleroid.core.network.model.MkResponse
import com.appleroid.core.network.model.join.JoinCodeRequest
import com.appleroid.core.network.model.join.JoinCodeVerify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

internal class JoinPhoneNumberVerifyRepository @Inject constructor(
    val joinApi: JoinApi
) : JoinRepository {
    override fun requestJoinCode(phoneNumber: String): Flow<MkResponse<String>> = flow {
        joinApi.requestJoinCode(phoneNumber)?.let {
            emit(it)
        } ?: run {
            emit(MkResponse("c", 2, "b", "a"))
        }
    }

    override fun getJoinCodeVerify(code: String): Flow<JoinCodeVerify> = flow {
        joinApi.getJoinCodeVerify(code)?.let {
            emit(it)
        }
    }
}