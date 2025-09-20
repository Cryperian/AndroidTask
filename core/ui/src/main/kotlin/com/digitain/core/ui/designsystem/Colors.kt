package com.digitain.core.ui.designsystem

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

data class AppColors(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val background: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val widgetBackground: Color,
    val cardBackground: Color,
    val winCardBackground: Color,
    val error: Color,
)

val LightColorScheme = AppColors(
    primary = Color(0xFF181818),
    secondary = Color(0xFF181818),
    tertiary = Color(0xFF181818),
    background = Color(0xFFFAFAFA),
    textPrimary = Color(0xFF212121),
    textSecondary = Color(0x99212121),
    widgetBackground = Color(0xFFFFFFFF),
    cardBackground = Color(0xFFFFFFFF),
    winCardBackground = Color(0xFFF5F5F5),
    error = Color(0xFFCB3535),
)

val DarkColorScheme = AppColors(
    primary = Color(0xFF181818),
    secondary = Color(0xFF181818),
    tertiary = Color(0xFF181818),
    background = Color(0xFF181818),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0x80FFFFFF),
    widgetBackground = Color(0xFF1F1F1F),
    cardBackground = Color(0xFF262626),
    winCardBackground = Color(0xFF2E2E2E),
    error = Color(0xFFCB3535),
)

val lightMaterialColorScheme = lightColorScheme(
    background = LightColorScheme.background,
)

val darkMaterialColorScheme = darkColorScheme(
    background = DarkColorScheme.background,
)

