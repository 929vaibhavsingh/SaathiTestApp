package com.saathi.features.features.wallet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun LoadSuccessPaymentDialog(onDialogDismiss :()->Unit) {
    Dialog(
        onDismissRequest = {},
        DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
                .zIndex(10F),
            contentAlignment = Alignment.Center
        ) {
            PaymentSuccessScreen(onDialogDismiss)
        }
    }
}

@Composable
private fun PaymentSuccessScreen(onDialogDismiss: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = BlueScreenGradientBrush)
            .padding(bottom = 40.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(bottom = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_payment_success), // Replace with your image resource
                contentDescription = stringResource(R.string.earn_100_everytime),
            )
            Text(
                text = "₹500 has been successfully \ntransferred ",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = "Money sent to kamalkumar@icici",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),

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

    LaunchedEffect(key1 = countdown) {
        if (countdown > 0) {
            delay(1000L)
            countdown--
        }
    }
    buttonColor = if (countdown == 0) {
        Color.Yellow
    } else {
        Color.White
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Redirecting in $countdown..",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),

                )
        )
        OutlinedButton(

            onClick = { if (countdown ==0)
            {
                onDialogDismiss.invoke()
            }}, modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, buttonColor)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_yellow_back), // Replace with your image resource
                    contentDescription = stringResource(R.string.next),
                    colorFilter = ColorFilter.tint(buttonColor)
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                    text = "Back",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 30.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = buttonColor,
                        textAlign = TextAlign.Center,
                    )
                )
            }

        }
    }


}

@Preview
@Composable
private fun LoadSuccessPreview() {
//    PaymentSuccessScreen( )
}


