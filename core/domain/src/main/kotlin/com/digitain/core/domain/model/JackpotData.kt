package com.digitain.core.domain.model

data class JackpotData(
    val digitsAfterPoint: Int,
    val currency: String,
    val currencySymbol: String,
    val widgets: JackpotWidget,
    val items: List<JackpotItem> = emptyList(),
)

data class JackpotItem(
    val current: Double,
    val wins: Int?,
    val largestWin: Double?,
    val largestWinDate: String?,
    val largestWinUser: String?,
    val lastWin: Double?,
    val lastWinDate: String?,
    val lastWinUser: String?,
    val topMonthlyWinners: List<Winner>,
    val topYearlyWinners: List<Winner>,
    val levelId: Int? = null,
    val order: Int? = null,
)

data class Winner(
    val winUser: String,
    val winAmount: Double,
    val winDate: String,
)

data class JackpotWidget(
    val name: String,
    val widgetInfos: List<WidgetInfo>,
)

data class WidgetInfo(
    val id: Int,
    val lobbyWidgetSettingId: Int,
    val levelId: Int,
    val order: Int,
    val state: Int,
)