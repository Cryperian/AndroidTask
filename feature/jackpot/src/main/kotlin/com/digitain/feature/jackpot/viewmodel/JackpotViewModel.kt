package com.digitain.feature.jackpot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitain.core.domain.usecase.GetJackpotDataUseCase
import com.digitain.core.ui.state.UiState
import com.digitain.feature.jackpot.intent.JackpotIntent
import com.digitain.feature.jackpot.mapper.toUiModel
import com.digitain.feature.jackpot.model.JackpotUiModel
import com.digitain.feature.jackpot.state.JackpotUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JackpotViewModel @Inject constructor(
    private val getJackpotDataUseCase: GetJackpotDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<JackpotUiState>(UiState.Loading)
    val uiState: StateFlow<JackpotUiState> = _uiState.asStateFlow()

    init {
        startFetchingData()
    }

    fun dispatch(intent: JackpotIntent) = when (intent) {
        is JackpotIntent.OnJackpotWidgetClick -> updateSuccess { it.copy(isBottomSheetVisible = true) }
        is JackpotIntent.OnBottomSheetDismiss -> updateSuccess { it.copy(isBottomSheetVisible = false) }
    }

    private inline fun updateSuccess(transform: (JackpotUiModel) -> JackpotUiModel) {
        _uiState.update { state ->
            if (state is UiState.Success) UiState.Success(transform(state.data)) else state
        }
    }

    private fun startFetchingData() {
        viewModelScope.launch {
            getJackpotDataUseCase()
                .collect { it.fold(::handleSuccess, ::handleError) }
        }
    }

    private fun handleSuccess(jackpotData: com.digitain.core.domain.model.JackpotData) {
        val uiModel = jackpotData.toUiModel()

        _uiState.update { state ->
            if (state is UiState.Success) {
                UiState.Success(
                    state.data.copy(
                        items = uiModel.items,
                        currency = uiModel.currency,
                        digitsAfterPoint = uiModel.digitsAfterPoint,
                    )
                )
            } else {
                UiState.Success(uiModel)
            }
        }
    }

    private fun handleError(exception: Throwable) {
        _uiState.value = UiState.Error(exception)
    }
}