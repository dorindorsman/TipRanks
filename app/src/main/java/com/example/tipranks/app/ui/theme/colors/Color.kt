package com.example.tipranks.app.ui.theme.colors

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFFFF9800) // Orange
val md_theme_light_onPrimary = Color(0xFFFFFFFF) // White
val md_theme_light_primaryContainer = Color(0xFFFFE0B2) // Light Orange
val md_theme_light_onPrimaryContainer = Color(0xFF4E2600) // Dark Brownish Orange
val md_theme_light_secondary = Color(0xFF616161) // Dark Gray
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFBDBDBD) // Light Gray
val md_theme_light_onSecondaryContainer = Color(0xFF212121) // Almost Black
val md_theme_light_tertiary = Color(0xFF757575) // Mid Gray
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFE0E0E0) // Light Gray
val md_theme_light_onTertiaryContainer = Color(0xFF1C1C1C) // Near Black
val md_theme_light_error = Color(0xFFD32F2F) // Red
val md_theme_light_errorContainer = Color(0xFFFFCDD2)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFFB71C1C)
val md_theme_light_background = Color(0xFFFFFFFF) // White
val md_theme_light_onBackground = Color(0xFF212121) // Almost Black
val md_theme_light_surface = Color(0xFFFFFFFF)
val md_theme_light_onSurface = Color(0xFF212121)
val md_theme_light_surfaceVariant = Color(0xFFE0E0E0) // Light Gray
val md_theme_light_onSurfaceVariant = Color(0xFF424242) // Dark Gray
val md_theme_light_outline = Color(0xFF757575) // Mid Gray
val md_theme_light_inverseOnSurface = Color(0xFFF5F5F5) // Very Light Gray
val md_theme_light_inverseSurface = Color(0xFF303030) // Dark Gray
val md_theme_light_inversePrimary = Color(0xFFE65100) // Deep Orange
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFFFF9800) // Match primary
val md_theme_light_outlineVariant = Color(0xFFBDBDBD) // Light Gray
val md_theme_light_scrim = Color(0xFF000000)

// Dark Theme Colors
val md_theme_dark_primary = Color(0xFFFFB74D) // Soft Orange
val md_theme_dark_onPrimary = Color(0xFF3E2723) // Dark Brown
val md_theme_dark_primaryContainer = Color(0xFFE65100) // Deep Orange
val md_theme_dark_onPrimaryContainer = Color(0xFFFFE0B2)
val md_theme_dark_secondary = Color(0xFFBDBDBD) // Light Gray
val md_theme_dark_onSecondary = Color(0xFF212121) // Near Black
val md_theme_dark_secondaryContainer = Color(0xFF424242) // Dark Gray
val md_theme_dark_onSecondaryContainer = Color(0xFFBDBDBD)
val md_theme_dark_tertiary = Color(0xFFE0E0E0) // Light Gray
val md_theme_dark_onTertiary = Color(0xFF1C1C1C) // Near Black
val md_theme_dark_tertiaryContainer = Color(0xFF616161) // Dark Gray
val md_theme_dark_onTertiaryContainer = Color(0xFFE0E0E0)
val md_theme_dark_error = Color(0xFFFF8A80) // Light Red
val md_theme_dark_errorContainer = Color(0xFFB71C1C)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFCDD2)
val md_theme_dark_background = Color(0xFF121212) // Near Black
val md_theme_dark_onBackground = Color(0xFFE0E0E0) // Light Gray
val md_theme_dark_surface = Color(0xFF121212)
val md_theme_dark_onSurface = Color(0xFFE0E0E0)
val md_theme_dark_surfaceVariant = Color(0xFF424242) // Dark Gray
val md_theme_dark_onSurfaceVariant = Color(0xFFC3C7CF) // Mid Gray
val md_theme_dark_outline = Color(0xFF8D8D8D) // Gray Outline
val md_theme_dark_inverseOnSurface = Color(0xFF121212)
val md_theme_dark_inverseSurface = Color(0xFFE0E0E0)
val md_theme_dark_inversePrimary = Color(0xFFFF9800) // Match light primary
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFFFB74D) // Soft Orange
val md_theme_dark_outlineVariant = Color(0xFF424242) // Dark Gray
val md_theme_dark_scrim = Color(0xFF000000)

val seed = Color(0xFFFF9800) // Base color set to Orange

val ColorScheme.rateGreen: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF388E3C) else Color(0xFF4CAF50)

val ColorScheme.rateRed: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFD32F2F) else Color(0xFFF44336)

val ColorScheme.rateOrange: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFF9800) else Color(0xFFFFC107)
