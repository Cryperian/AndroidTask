package com.digitain.feature.jackpot.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.digitain.feature.jackpot.intent.JackpotIntent
import com.digitain.feature.jackpot.model.JackpotUiModel
import com.digitain.feature.jackpot.ui.component.JackpotBottomSheet
import com.digitain.feature.jackpot.ui.component.JackpotWidget
import com.digitain.feature.jackpot.ui.preview.JackpotDataPreviewParameterProvider

@Composable
fun JackpotScreenContent(
    modifier: Modifier = Modifier,
    data: JackpotUiModel,
    onIntent: (JackpotIntent) -> Unit = {},
) {
    val pagerState = rememberPagerState(pageCount = { data.items.size })

    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            key = { index -> data.items[index].name },
            pageSize = PageSize.Fill,
        ) { page ->
            val item = data.items[page]

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                JackpotWidget(
                    amount = item.current,
                    iconResId = item.iconResId,
                    backgroundResId = item.bgResId,
                    isAppear = pagerState.currentPage == page,
                ) {
                    onIntent(JackpotIntent.OnJackpotWidgetClick(item))
                }
            }
        }
    }

    if (data.isBottomSheetVisible) {
        JackpotBottomSheet(
            items = data.items,
            onDismissRequest = {
                onIntent(JackpotIntent.OnBottomSheetDismiss)
            },
        )
    }
}

@Preview
@Composable
private fun JackpotScreenContentPreview(
    @PreviewParameter(JackpotDataPreviewParameterProvider::class) data: JackpotUiModel
) {
    JackpotScreenContent(data = data)
}