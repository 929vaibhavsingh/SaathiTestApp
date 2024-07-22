package com.saathi.features.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shadow

val PurpleTextGradientBrush = Brush.linearGradient(
    colors = listOf(TextPurpleGradient1, TextPurpleGradient2),
    start = Offset(0f, 3f),
)

val PurpleTextShadow = Shadow(
    color = Purple.copy(alpha = 0.3f),
    offset = Offset(0f, 3f),
    blurRadius = 0f
)

val YellowTextGradientBrush = Brush.linearGradient(
    colors = listOf(TextYellowGradient1, TextYellowGradient2,TextYellowGradient3,TextYellowGradient4),
    start = Offset(0f, 3f),
)

val YellowTextShadow = Shadow(
    color = Purple.copy(alpha = 0.3f),
    offset = Offset(0f, 3f),
    blurRadius = 0f
)

