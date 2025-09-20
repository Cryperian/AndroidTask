package com.digitain.feature.jackpot.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.digitain.core.ui.designsystem.AppTheme
import com.digitain.core.ui.state.UiState
import com.digitain.feature.jackpot.R
import com.digitain.feature.jackpot.viewmodel.JackpotViewModel

const val JACKPOT_SCREEN = "jackpot_screen"

@Composable
fun JackpotScreen(
    modifier: Modifier = Modifier,
    viewModel: JackpotViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        when (val state = uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator(color = AppTheme.colors.primary)
            }

            is UiState.Success -> {
                JackpotScreenContent(
                    modifier = Modifier.fillMaxSize(),
                    data = state.data,
                    onIntent = viewModel::dispatch,
                )
            }

            is UiState.Error -> {
                Column(
                    modifier = Modifier
                        .padding(26.dp)
                ) {
                    Text(
                        text = stringResource(R.string.error_message),
                        color = AppTheme.colors.error,
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    Text(
                        text = state.exception.message ?: stringResource(R.string.error_message),
                        color = AppTheme.colors.error,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}