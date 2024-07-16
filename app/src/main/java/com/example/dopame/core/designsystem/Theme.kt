package com.example.dopame.core.designsystem

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

fun colors() = DopaMeColor()
fun fonts() = DopaMeTypography()

@Composable
fun DopaMeTheme (
    colors: DopaMeColor = colors(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    SideEffect {
        if (!view.isInEditMode) {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.gray30.toArgb()
        }
    }
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides fonts()
    ) {
        content()
    }
}