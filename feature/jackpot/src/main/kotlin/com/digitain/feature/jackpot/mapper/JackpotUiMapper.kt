package com.digitain.feature.jackpot.mapper

import com.digitain.core.common.extension.formatDateTime
import com.digitain.core.domain.model.JackpotData
import com.digitain.core.domain.model.JackpotItem
import com.digitain.feature.jackpot.R
import com.digitain.feature.jackpot.model.JackpotItemUiModel
import com.digitain.feature.jackpot.model.JackpotUiModel
import com.digitain.feature.jackpot.model.WinUiModel
import kotlinx.collections.immutable.toPersistentList
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

enum class JackpotType {
    CLUB, DIAMOND, HEART, SPADE
}

fun JackpotData.toUiModel(): JackpotUiModel {
    val formatter = amountFormatter()
    val uiItems = items.map { item ->
        val type = getJackpotTypeByLevelId(item.levelId ?: 1)
        item.toUiModel(type, formatter)
    }

    return JackpotUiModel(
        items = uiItems.toPersistentList(),
        currency = currency,
        currencySymbol = currencySymbol,
        digitsAfterPoint = digitsAfterPoint
    )
}

private fun JackpotItem.toUiModel(
    type: JackpotType,
    formatter: DecimalFormat,
): JackpotItemUiModel {
    val winData = createWinData(formatter)

    return JackpotItemUiModel(
        name = getName(type),
        current = formatter.format(current),
        winData = winData,
        minBet = getMinBet(type),
        iconResId = getIconResId(type),
        bgResId = getBackgroundResId(type),
    )
}

private fun JackpotItem.createWinData(formatter: DecimalFormat): WinUiModel? {
    val wins = wins ?: return null
    val largestWin = largestWin ?: return null
    val largestWinDate = largestWinDate ?: return null
    val largestWinUser = largestWinUser ?: return null
    val lastWin = lastWin ?: return null
    val lastWinDate = lastWinDate ?: return null
    val lastWinUser = lastWinUser ?: return null

    return WinUiModel(
        wins = wins,
        largestWin = formatter.format(largestWin),
        largestWinDate = largestWinDate.formatDateTime(),
        largestWinUser = largestWinUser,
        lastWin = formatter.format(lastWin),
        lastWinDate = lastWinDate.formatDateTime(),
        lastWinUser = lastWinUser,
        largeBetId = 7044145810,
        lastBetId = 9545565412,
    )
}

private fun getBackgroundResId(type: JackpotType): Int {
    return when (type) {
        JackpotType.CLUB -> R.drawable.bg_gold
        JackpotType.DIAMOND -> R.drawable.bg_dimond
        JackpotType.HEART -> R.drawable.bg_silver
        JackpotType.SPADE -> R.drawable.bg_bronze
    }
}

private fun getIconResId(type: JackpotType): Int {
    return when (type) {
        JackpotType.CLUB -> R.drawable.ic_gold
        JackpotType.DIAMOND -> R.drawable.ic_dimond
        JackpotType.HEART -> R.drawable.ic_silver
        JackpotType.SPADE -> R.drawable.ic_bronze
    }
}

private fun getName(type: JackpotType): String {
    return when (type) {
        JackpotType.CLUB -> "CLUB"
        JackpotType.DIAMOND -> "DIAMOND"
        JackpotType.HEART -> "HEART"
        JackpotType.SPADE -> "SPADE"
    }
}

private fun getMinBet(type: JackpotType): String {
    return when (type) {
        JackpotType.CLUB -> "10 000"
        JackpotType.DIAMOND -> "8 000"
        JackpotType.HEART -> "5 000"
        JackpotType.SPADE -> "2 000"
    }
}

private fun getJackpotTypeByLevelId(levelId: Int): JackpotType {
    return when (levelId) {
        1 -> JackpotType.CLUB
        2 -> JackpotType.DIAMOND
        3 -> JackpotType.HEART
        4 -> JackpotType.SPADE
        else -> JackpotType.CLUB
    }
}

private fun JackpotData.amountFormatter(): DecimalFormat {
    val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        groupingSeparator = ' '
        decimalSeparator = '.'
    }

    val pattern = buildString {
        append("#,##0")
        if (digitsAfterPoint > 0) {
            append(".")
            append("0".repeat(digitsAfterPoint))
        }
    }

    return DecimalFormat(pattern, symbols)
}