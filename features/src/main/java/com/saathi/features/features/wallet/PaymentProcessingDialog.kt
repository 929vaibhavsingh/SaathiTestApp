package com.saathi.features.features.wallet

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.zIndex
import com.saathi.features.R
import com.saathi.features.theme.BlueScreenGradientBrush

@Composable
fun LoadPaymentProcessingDialog() {
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .zIndex(10f),
            contentAlignment = Alignment.Center
        ) {
            PaymentProcessingScreen()
        }
    }
}

@Composable
fun PaymentProcessingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueScreenGradientBrush)
            .padding(horizontal = 16.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RotatingImageProgressBar(
            painter = painterResource(id = R.drawable.ic_progressbar),
            size = 120.dp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "We are transferring your amount",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Please do not hit back button or close this screen until the transaction is complete",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun RotatingImageProgressBar(
    painter: Painter,
    size: Dp,
    animationDuration: Int = 1500
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration)
        ), label = ""
    )

    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(size)
                .rotate(angle),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun PreviewPaymentProcessingScreen() {
    PaymentProcessingScreen()
}
