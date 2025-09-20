package com.digitain.feature.jackpot.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.digitain.feature.jackpot.R
import com.digitain.feature.jackpot.model.JackpotItemUiModel
import com.digitain.feature.jackpot.model.JackpotUiModel
import com.digitain.feature.jackpot.model.WinUiModel
import kotlinx.collections.immutable.toPersistentList

class JackpotDataPreviewParameterProvider : PreviewParameterProvider<JackpotUiModel> {
    override val values = sequenceOf(
        JackpotUiModel(
            items = listOf(
                JackpotItemUiModel(
                    name = "CLUB",
                    current = "75 456 221.35",
                    winData = WinUiModel(
                        wins = 1234,
                        largestWin = "2 500 000.00",
                        largestWinDate = "24.04.2022 | 12:20",
                        largestWinUser = "Player123",
                        lastWin = "125 000.50",
                        lastWinDate = "04.01.2023 | 15:35",
                        lastWinUser = "WinnerXYZ",
                        largeBetId = 23283749823,
                        lastBetId = 34634634636,
                    ),
                    iconResId = R.drawable.ic_gold,
                    bgResId = R.drawable.bg_gold,
                    minBet = "10 000",
                ),
                JackpotItemUiModel(
                    name = "DIAMOND",
                    current = "8 350 225.77",
                    winData = WinUiModel(
                        wins = 987,
                        largestWin = "1 800 000.00",
                        largestWinDate = "24.04.2022 | 12:20",
                        largestWinUser = "DiamondKing",
                        lastWin = "95 000.25",
                        lastWinDate = "04.01.2023 | 15:35",
                        lastWinUser = "LuckyDiamond",
                        largeBetId = 43283749823,
                        lastBetId = 54634634636,
                    ),
                    iconResId = R.drawable.ic_dimond,
                    bgResId = R.drawable.bg_dimond,
                    minBet = "8 000",
                ),
                JackpotItemUiModel(
                    name = "HEART",
                    current = "2 115 444.12",
                    iconResId = R.drawable.ic_silver,
                    bgResId = R.drawable.bg_silver,
                    minBet = "5 000",
                ),
                JackpotItemUiModel(
                    name = "SPADE",
                    current = "8 154 558.69",
                    iconResId = R.drawable.ic_bronze,
                    bgResId = R.drawable.bg_bronze,
                    minBet = "2 000",
                )
            ).toPersistentList(),
            currency = "USD",
            currencySymbol = "$",
            digitsAfterPoint = 2
        )
    )
}