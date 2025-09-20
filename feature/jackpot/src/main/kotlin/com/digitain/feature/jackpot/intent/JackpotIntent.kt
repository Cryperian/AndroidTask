package com.digitain.feature.jackpot.intent

import com.digitain.feature.jackpot.model.JackpotItemUiModel

sealed interface JackpotIntent {
    data class OnJackpotWidgetClick(val item: JackpotItemUiModel) : JackpotIntent
    data object OnBottomSheetDismiss : JackpotIntent
}