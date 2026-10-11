package com.example.r2mbrands.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = R2MTeal,
    onPrimary = R2MWhite,
    primaryContainer = R2MTealSoft,
    onPrimaryContainer = R2MTealDeep,
    secondary = R2MCyan,
    onSecondary = R2MWhite,
    secondaryContainer = R2MTealSoft,
    onSecondaryContainer = R2MTealDeep,
    tertiary = R2MAmber,
    onTertiary = R2MWhite,
    tertiaryContainer = R2MAmberSoft,
    onTertiaryContainer = R2MInk,
    background = R2MSurface,
    onBackground = R2MInk,
    surface = R2MCard,
    onSurface = R2MInk,
    surfaceVariant = R2MSurfaceAlt,
    onSurfaceVariant = R2MInkMuted,
    outline = R2MShadowDark,
    outlineVariant = R2MInkLight
)

@Composable
fun R2MBrandsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            window?.let {
                it.statusBarColor = R2MSurface.toArgb()
                WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = true
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
