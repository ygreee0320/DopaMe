package com.example.dopame.core.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object DopaMeTheme {
    val colors: DopaMeColor
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

    val typography: DopaMeTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current
}