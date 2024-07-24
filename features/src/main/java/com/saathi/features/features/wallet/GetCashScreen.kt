package com.saathi.features.features.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavHostController
import com.saathi.features.R
import com.saathi.features.constants.Screen
import com.saathi.features.features.wallet.viewmodel.WalletViewModel
import com.saathi.features.theme.BlueScreenGradientBrush
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.YellowButtonGradientBrush
import com.saathi.features.theme.YellowTextGradientBrush
import com.saathi.features.theme.YellowTextShadow

@Composable
fun GetCashScreen(navController: NavHostController, viewModel: WalletViewModel = hiltViewModel()) {
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet(viewModel, onDismiss = { showSheet = false }) {
            showSheet = false
            navController.navigate(Screen.PaymentProcessingScreen.route)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueScreenGradientBrush)
            .padding(16.dp)
    ) {
        Header()
        Spacer(modifier = Modifier.height(18.dp))
        EarningsCard()
        Spacer(modifier = Modifier.height(23.dp))
        GetCashButton(onClick = { showSheet = true })
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .clickable { /* Handle back navigation */ }
                .padding(10.dp)
        )
        Text(
            text = "Get Cash",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
}

@Composable
private fun EarningsCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF281D5D), RoundedCornerShape(12.dp))
            .padding(16.dp)
            .height(617.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
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
                fontWeight = FontWeight.Normal,
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
                fontWeight = FontWeight.Bold,
                color = Purple50,
                textAlign = TextAlign.Center
            )
        )
    }
}
