package com.digitain.feature.jackpot.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.digitain.core.ui.designsystem.AppTheme
import com.digitain.feature.jackpot.R

@Composable
fun JackpotWidget(
    modifier: Modifier = Modifier,
    amount: String,
    @DrawableRes iconResId: Int,
    @DrawableRes backgroundResId: Int,
    isAppear: Boolean = true,
    onClick: () -> Unit,
) {
    var hasAnimated by remember { mutableStateOf(false) }
    var startAnimation by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.5f,
        animationSpec = tween(durationMillis = 600),
        label = "icon_scale"
    )

    LaunchedEffect(isAppear) {
        if (isAppear && !hasAnimated) {
            startAnimation = true
            hasAnimated = true
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .wrapContentWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(color = AppTheme.colors.widgetBackground)
            .clickable { onClick() },
    ) {
        Image(
            painter = painterResource(id = backgroundResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(18.dp)),
            contentScale = ContentScale.Crop,
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .matchParentSize()
                .padding(vertical = 10.dp, horizontal = 16.dp),
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .scale(scale)
            )

            Text(
                text = amount,
                color = AppTheme.colors.textPrimary,
                style = AppTheme.typography.titleLarge,
            )

            Box(modifier = Modifier.size(36.dp))
        }
    }

}

@Preview
@Composable
private fun JackpotWidgetPreview() {
    Column(
        modifier = Modifier.padding(22.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp),
    ) {
        JackpotWidget(
            amount = "75 456 221.35",
            iconResId = R.drawable.ic_dimond,
            backgroundResId = R.drawable.bg_dimond,
            onClick = { },
        )

        JackpotWidget(
            amount = "8 350 225.77",
            iconResId = R.drawable.ic_gold,
            backgroundResId = R.drawable.bg_gold,
            onClick = { },
        )

        JackpotWidget(
            amount = "2 115 444.12",
            iconResId = R.drawable.ic_silver,
            backgroundResId = R.drawable.bg_silver,
            onClick = { },
        )

        JackpotWidget(
            amount = "8154 558.69",
            iconResId = R.drawable.ic_bronze,
            backgroundResId = R.drawable.bg_bronze,
            onClick = { },
        )
    }
}