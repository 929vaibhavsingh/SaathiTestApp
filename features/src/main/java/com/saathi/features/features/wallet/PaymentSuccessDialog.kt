package com.saathi.features.features.wallet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.zIndex
import com.saathi.features.R
import com.saathi.features.theme.BlueScreenGradientBrush
import kotlinx.coroutines.delay

@Composable
fun LoadSuccessPaymentDialog(onDialogDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .zIndex(10f),
            contentAlignment = Alignment.Center
        ) {
            PaymentSuccessScreen(onDialogDismiss)
        }
    }
}

@Composable
private fun PaymentSuccessScreen(onDialogDismiss: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = BlueScreenGradientBrush)
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_payment_success),
                contentDescription = stringResource(R.string.earn_100_everytime)
            )
            Text(
                text = "₹500 has been successfully \ntransferred",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "Money sent to kamalkumar@icici",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )
        }

        BackToMainScreen(onDialogDismiss)
    }
}

@Composable
fun BackToMainScreen(onDialogDismiss: () -> Unit) {
    var buttonColor by remember { mutableStateOf(Color.White) }
    var countdown by remember { mutableStateOf(5) }

    LaunchedEffect(countdown) {
        if (countdown > 0) {
            delay(1000L)
            countdown--
        }
    }

    buttonColor = if (countdown == 0) Color.Yellow else Color.White

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Redirecting in $countdown...",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        )
        OutlinedButton(
            onClick = {
                if (countdown == 0) {
                    onDialogDismiss()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, buttonColor)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_yellow_back),
                    contentDescription = stringResource(R.string.next),
                    colorFilter = ColorFilter.tint(buttonColor)
                )
                Text(
                    text = "Back",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 30.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight.Bold,
                        color = buttonColor,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun LoadSuccessPreview() {
    LoadSuccessPaymentDialog(onDialogDismiss = {})
}
