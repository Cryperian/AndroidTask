package com.digitain.core.ui.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppColors = staticCompositionLocalOf { DarkColorScheme }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    val materialColors = if (darkTheme) darkMaterialColorScheme else lightMaterialColorScheme

    CompositionLocalProvider(LocalAppColors provides colors) {
        MaterialTheme(
            colorScheme = materialColors,
            typography = Typography,
            content = content,
        )
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography
        @Composable
        get() = MaterialTheme.typography
}