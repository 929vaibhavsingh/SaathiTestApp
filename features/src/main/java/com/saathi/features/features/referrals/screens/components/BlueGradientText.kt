package com.saathi.features.features.referrals.screens.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.saathi.features.theme.PurpleTextGradientBrush
import com.saathi.features.theme.PurpleTextShadow

@Composable
fun BlueGradientText(text : String) {
    Text(
        text = text.uppercase(),
        style = TextStyle(
            brush = PurpleTextGradientBrush,
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily.Default,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            shadow = PurpleTextShadow
        ),
    )
}