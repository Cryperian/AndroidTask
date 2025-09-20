package com.digitain.feature.jackpot.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class JackpotUiModel(
    val items: ImmutableList<JackpotItemUiModel>,
    val currency: String,
    val currencySymbol: String,
    val digitsAfterPoint: Int,
    val isBottomSheetVisible: Boolean = false,
)

@Immutable
data class JackpotItemUiModel(
    val name: String,
    val current: String,
    val winData: WinUiModel? = null,
    val minBet: String,
    @DrawableRes
    val iconResId: Int,
    @DrawableRes
    val bgResId: Int,
)

@Immutable
data class WinUiModel(
    val wins: Int,
    val largestWin: String,
    val largestWinDate: String,
    val largestWinUser: String,
    val lastWin: String,
    val lastWinDate: String,
    val lastWinUser: String,
    val largeBetId: Long,
    val lastBetId: Long,
)