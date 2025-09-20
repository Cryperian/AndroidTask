package com.digitain.feature.jackpot.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitain.core.ui.designsystem.AppTheme
import com.digitain.feature.jackpot.R
import com.digitain.feature.jackpot.model.JackpotItemUiModel
import com.digitain.feature.jackpot.model.JackpotUiModel
import com.digitain.feature.jackpot.ui.preview.JackpotDataPreviewParameterProvider

@Composable
fun JackpotCard(
    data: JackpotItemUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(AppTheme.colors.cardBackground)
            .padding(12.dp)
    ) {
        CardHeader(
            modifier = Modifier.fillMaxWidth(),
            typeName = data.name,
            minBet = data.minBet,
            iconResId = data.iconResId,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 12.dp),
            textAlign = TextAlign.Center,
            text = data.current,
            color = AppTheme.colors.textPrimary,
            style = AppTheme.typography.titleLarge,
        )

        if (data.winData != null) {
            WinCard(
                title = stringResource(R.string.biggest_win),
                amount = data.winData.largestWin,
                formattedDate = data.winData.largestWinDate,
                betId = data.winData.largeBetId,
            )

            WinCard(
                modifier = Modifier.padding(top = 8.dp),
                title = stringResource(R.string.latest_win),
                amount = data.winData.lastWin,
                formattedDate = data.winData.lastWinDate,
                betId = data.winData.lastBetId,
            )
        } else {
            WinEmptyCard(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun CardHeader(
    typeName: String,
    minBet: String,
    @DrawableRes iconResId: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )

        Text(
            text = typeName,
            color = AppTheme.colors.textPrimary,
            style = AppTheme.typography.bodyMedium.copy(fontSize = 13.sp),
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(R.string.min_bet),
            color = AppTheme.colors.textSecondary,
            style = AppTheme.typography.bodyMedium.copy(fontSize = 13.sp),
        )

        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = minBet,
            color = AppTheme.colors.textPrimary,
            style = AppTheme.typography.bodyMedium.copy(fontSize = 13.sp),
        )
    }
}

@Composable
private fun WinCard(
    title: String,
    amount: String,
    formattedDate: String,
    betId: Long,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(AppTheme.colors.winCardBackground)
            .padding(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = title,
                color = AppTheme.colors.textPrimary,
                style = AppTheme.typography.bodyMedium,
            )

            Text(
                text = amount,
                color = AppTheme.colors.textPrimary,
                style = AppTheme.typography.bodyMedium,
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = formattedDate,
                color = AppTheme.colors.textSecondary,
                style = AppTheme.typography.bodySmall,
            )

            Text(
                text = stringResource(R.string.bet_id, betId),
                color = AppTheme.colors.textSecondary,
                style = AppTheme.typography.bodySmall,
            )
        }
    }
}

@Composable
private fun WinEmptyCard(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(AppTheme.colors.winCardBackground)
            .padding(12.dp),
    ) {
        Text(
            text = stringResource(R.string.no_winners),
            color = AppTheme.colors.textSecondary,
            style = AppTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
private fun JackpotCardPreview(
    @PreviewParameter(JackpotDataPreviewParameterProvider::class) data: JackpotUiModel
) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        JackpotCard(data = data.items.first())
        JackpotCard(data = data.items.last())
    }
}