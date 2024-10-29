package com.appleroid.core.domain

import com.appleroid.core.data.repository.join.JoinRepository
import com.appleroid.model.MkData
import java.util.concurrent.Flow
import javax.inject.Inject

class RequestJoinCodeUseCase @Inject constructor(
    private val repository: JoinRepository
) {
    operator fun invoke(phoneNumber: String): Flow<MkData<String>>? = repository.requestJoinCode(phoneNumber = phoneNumber)
}
