package com.digitain.core.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class JackpotResponseDto(
    val digitsAfterPoint: Int,
    val currency: String,
    val currencySymbol: String,
    val clubs: JackpotItemDto,
    val diamonds: JackpotItemDto,
    val hearts: JackpotItemDto,
    val spades: JackpotItemDto,
    val jackpotWidget: JackpotWidgetDto
)

@Serializable
data class JackpotItemDto(
    val current: Double,
    val wins: Int?,
    val largestWin: Double?,
    val largestWinDate: String?,
    val largestWinUser: String?,
    val lastWin: Double?,
    val lastWinDate: String?,
    val lastWinUser: String?,
    val topMonthlyWinners: List<WinnerDto>?,
    val topYearlyWinners: List<WinnerDto>?
)

@Serializable
data class WinnerDto(
    val winUser: String,
    val winAmount: Double,
    val winDate: String
)

@Serializable
data class JackpotWidgetDto(
    val name: String,
    val widgetInfos: List<WidgetInfoDto>
)

@Serializable
data class WidgetInfoDto(
    val id: Int,
    val lobbyWidgetSettingId: Int,
    val levelId: Int,
    val order: Int,
    val state: Int
)