package com.example.dopame.core.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class DopaMeColor (
    val primary100 : Color = Color(0xFFEDFBCB),
    val primary90 : Color = Color(0xFFE0F8A5),
    val primary80 : Color = Color(0xFFD3F57F),
    val primary70 : Color = Color(0xFFC7F25A),
    val primary60 : Color = Color(0xFFBAEF35),
    val primary50 : Color = Color(0xFFABE812),
    val primary40 : Color = Color(0xFF88B21F),
    val primary30 : Color = Color(0xFF6D8F19),
    val primary20 : Color = Color(0xFF536C13),
    val primary10 : Color = Color(0xFF384A0D),

    val gray100 : Color = Color(0xFFFCFCFD),
    val gray90 : Color = Color(0xFFDFE1E7),
    val gray80 : Color = Color(0xFFC2C6D1),
    val gray70 : Color = Color(0xFFA3AABD),
    val gray60 : Color = Color(0xFF868EA7),
    val gray50 : Color = Color(0xFF697391),
    val gray40 : Color = Color(0xFF545B73),
    val gray30 : Color = Color(0xFF3D4357),
    val gray20 : Color = Color(0xFF282C39),
    val gray10 : Color = Color(0xFF13151B),

    val sub100 : Color = Color(0xFFFFFFFF),
    val sub90 : Color = Color(0xFFEEE2FE),
    val sub80 : Color = Color(0xFFD7BBFC),
    val sub70 : Color = Color(0xFFC194FA),
    val sub60 : Color = Color(0xFFA96BF8),
    val sub50 : Color = Color(0xFF9346F6),
    val sub40 : Color = Color(0xFF8036DD),
    val sub30 : Color = Color(0xFF6B22C9),
    val sub20 : Color = Color(0xFF591CA6),
    val sub10 : Color = Color(0xFF461683),
)

val LocalColors = staticCompositionLocalOf { DopaMeColor() }