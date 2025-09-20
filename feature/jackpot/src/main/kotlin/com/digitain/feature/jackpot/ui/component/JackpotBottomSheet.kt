package com.digitain.feature.jackpot.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.digitain.core.ui.designsystem.AppTheme
import com.digitain.feature.jackpot.model.JackpotItemUiModel
import com.digitain.feature.jackpot.model.JackpotUiModel
import com.digitain.feature.jackpot.ui.preview.JackpotDataPreviewParameterProvider
import kotlinx.collections.immutable.ImmutableList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JackpotBottomSheet(
    modifier: Modifier = Modifier,
    items: ImmutableList<JackpotItemUiModel>,
    onDismissRequest: () -> Unit,
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = bottomSheetState,
        modifier = modifier,
        containerColor = AppTheme.colors.background,
    ) {
        BottomSheetContent(
            items = items,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
private fun BottomSheetContent(
    modifier: Modifier = Modifier,
    items: ImmutableList<JackpotItemUiModel>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = modifier,
    ) {
        items(
            items = items,
            key = { item -> item.name },
        ) { item ->
            JackpotCard(data = item)
        }
    }
}

@Preview
@Composable
private fun JackpotBottomSheetContentPreview(
    @PreviewParameter(JackpotDataPreviewParameterProvider::class) data: JackpotUiModel
) {
    BottomSheetContent(items = data.items)
}