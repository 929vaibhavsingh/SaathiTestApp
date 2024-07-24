package com.saathi.features.features.referrals.screens.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.saathi.features.R
import com.saathi.features.theme.YellowTextGradientBrush
import com.saathi.features.theme.YellowTextShadow


@Composable
fun DailyEarnText() {
    Text(
        text = stringResource(R.string.tak_roz_kamayein).uppercase(),

        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Center,
            letterSpacing = 1.6.sp,
            brush = YellowTextGradientBrush,
            shadow = YellowTextShadow,
        )
    )
}

@Composable
fun ReferAmountText() {
    Text(
        text = stringResource(R.string._1_000),
        style = TextStyle(
            brush = YellowTextGradientBrush,
            fontSize = 80.sp,
            lineHeight = 80.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight(700),
            shadow = YellowTextShadow,
            textAlign = TextAlign.Center,
        )
    )
}
