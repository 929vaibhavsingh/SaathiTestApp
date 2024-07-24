package com.saathi.features.features.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.saathi.features.R
import com.saathi.features.component.Header
import com.saathi.features.features.wallet.viewmodel.WalletViewModel
import com.saathi.features.theme.BlueScreenGradientBrush
import com.saathi.features.theme.DarkBlue
import com.saathi.features.theme.YellowButtonGradientBrush
import com.saathi.features.theme.YellowTextGradientBrush
import com.saathi.features.theme.YellowTextShadow

@Composable
fun GetCashScreen(
    viewModel: WalletViewModel = hiltViewModel(),
    onDismissUpi: () -> Unit,
    onClickBackButton: () -> Unit
) {
    var showUpiBottomSheet by remember { mutableStateOf(false) }

    if (showUpiBottomSheet) {
        EnterUpiBottomSheet(viewModel, onDismiss = {
            showUpiBottomSheet = false
         }){isPaymentSuccess ->
            if (isPaymentSuccess)
            {
                showUpiBottomSheet = false
                onDismissUpi.invoke()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueScreenGradientBrush)
            .padding(16.dp)
    ) {
        Header("Get Cash", onClickBackButton)
        Spacer(modifier = Modifier.height(18.dp))
        EarningsCard(
            Modifier
                .fillMaxWidth()
                .background(Color(0xFF281D5D), RoundedCornerShape(12.dp))
                .padding(16.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.height(23.dp))
        GetCashButton(onClick = { showUpiBottomSheet = true })
    }
}


@Composable
private fun EarningsCard(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_amount_wallet),
            contentDescription = "Arrow Right",
            contentScale = ContentScale.None
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "₹500",
            style = TextStyle(
                fontSize = 52.sp,
                lineHeight = 56.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                brush = YellowTextGradientBrush,
                shadow = YellowTextShadow,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = "Your Earnings",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
private fun GetCashButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(YellowButtonGradientBrush),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = "Get Cash",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 30.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                color = DarkBlue,
                textAlign = TextAlign.Center
            )
        )
    }
}
