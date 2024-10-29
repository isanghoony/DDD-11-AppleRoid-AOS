package com.appleroid.feature.join

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.appleroid.core.domain.RequestJoinCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val requestJoinCodeUseCase: RequestJoinCodeUseCase,
) : ViewModel() {

}