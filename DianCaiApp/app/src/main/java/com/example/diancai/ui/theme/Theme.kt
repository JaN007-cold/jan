package com.example.diancai.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = OrangePrimary,
    onPrimary = SurfaceWhite,
    secondary = AmberSecondary,
    background = LightBackground,
    surface = SurfaceWhite,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
)

@Composable
fun DianCaiTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightColors, content = content)
}
