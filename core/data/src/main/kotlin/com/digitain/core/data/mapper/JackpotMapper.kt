package com.digitain.core.data.mapper

import com.digitain.core.domain.model.*
import com.digitain.core.network.dto.*

fun JackpotResponseDto.toDomain(): JackpotData {
    val clubsItem = clubs.toDomain()
    val diamondsItem = diamonds.toDomain()
    val heartsItem = hearts.toDomain()
    val spadesItem = spades.toDomain()

    val itemsMap = mapOf(
        1 to clubsItem,
        2 to diamondsItem,
        3 to heartsItem,
        4 to spadesItem
    )

    val orderedItems = jackpotWidget.widgetInfos
        .sortedBy { it.order }
        .mapNotNull { widgetInfo ->
            itemsMap[widgetInfo.levelId]?.copy(
                levelId = widgetInfo.levelId,
                order = widgetInfo.order
            )
        }

    return JackpotData(
        digitsAfterPoint = digitsAfterPoint,
        currency = currency,
        currencySymbol = currencySymbol,
        widgets = jackpotWidget.toDomain(),
        items = orderedItems
    )
}

private fun JackpotItemDto.toDomain(): JackpotItem {
    return JackpotItem(
        current = current,
        wins = wins,
        largestWin = largestWin,
        largestWinDate = largestWinDate,
        largestWinUser = largestWinUser,
        lastWin = lastWin,
        lastWinDate = lastWinDate,
        lastWinUser = lastWinUser,
        topMonthlyWinners = topMonthlyWinners?.map { it.toDomain() } ?: emptyList(),
        topYearlyWinners = topYearlyWinners?.map { it.toDomain() } ?: emptyList(),
        levelId = null,
        order = null
    )
}

private fun WinnerDto.toDomain(): Winner {
    return Winner(
        winUser = winUser,
        winAmount = winAmount,
        winDate = winDate
    )
}

private fun JackpotWidgetDto.toDomain(): JackpotWidget {
    return JackpotWidget(
        name = name,
        widgetInfos = widgetInfos.map { it.toDomain() }
    )
}

private fun WidgetInfoDto.toDomain(): WidgetInfo {
    return WidgetInfo(
        id = id,
        lobbyWidgetSettingId = lobbyWidgetSettingId,
        levelId = levelId,
        order = order,
        state = state
    )
}