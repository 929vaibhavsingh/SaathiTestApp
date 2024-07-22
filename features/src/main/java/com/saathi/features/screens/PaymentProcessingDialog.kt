package com.saathi.features.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.features.theme.BlueScreenGradientBrush


//@Composable
//fun PaymentProcessingScreen() {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.fillMaxSize().background(brush = BlueScreenGradientBrush)
//    ) {
//        CustomerCircularProgressBar()
//        Text(
//            text = "Hold On",
//            style = TextStyle(
//                fontSize = 20.sp,
//                lineHeight = 28.sp,
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight(700),
//                color = Color(0xFFFFFFFF),
//                textAlign = TextAlign.Center,
//            )
//        )
//        Text(
//            text = "We are transferring your amount",
//            style = TextStyle(
//                fontSize = 14.sp,
//                lineHeight = 21.sp,
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight(400),
//                color = Color(0xFFFFFFFF),
//
//                )
//        )
//        Text(
//            text = "Please do not hit back button or close this screen until the transaction is complete",
//            style = TextStyle(
//                fontSize = 14.sp,
//                lineHeight = 21.sp,
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight(400),
//                color = Color(0xFFFFFFFF),
//
//                textAlign = TextAlign.Center,
//            )
//        )
//    }
//}
//
//@Composable
//fun CustomerCircularProgressBar(
//    size: Dp = 96.dp,
//    strokeWidth: Dp = 12.dp,
//    backgroundArcColor: Color = Color.LightGray
//) {
//    Canvas(modifier = Modifier.size(size)) {
//        // Background Arc Implementation
//        drawArc(
//            color = backgroundArcColor,
//            startAngle = 0f,
//            sweepAngle = 360f,
//            useCenter = false,
//            size = Size(size.toPx(), size.toPx()),
//            style = Stroke(width = strokeWidth.toPx())
//        )
//    }
//}
//
