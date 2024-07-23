package com.saathi.features.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavHostController
import com.saathi.features.R
import com.saathi.features.theme.BlueScreenGradientBrush
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.YellowButtonGradientBrush
import com.saathi.features.theme.YellowTextGradientBrush
import com.saathi.features.theme.YellowTextShadow

@Composable
fun GetCashScreen(navController: NavHostController) {
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet {
            showSheet = false
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = BlueScreenGradientBrush)
            .padding(16.dp),

        ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back_arrow),
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Get Cash", style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(700),
                    color = Color.White,

                    )
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(617.dp)
                .background(color = Color(0xFF281D5D), shape = RoundedCornerShape(size = 12.dp))
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "₹500", style = TextStyle(
                    fontSize = 52.sp,
                    lineHeight = 56.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(400),
                    brush = YellowTextGradientBrush,
                    shadow = YellowTextShadow,
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                text = "Your Earnings", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.height(23.dp))
        Button(
            onClick = {
                showSheet = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(brush = YellowButtonGradientBrush),

            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),


            ) {

            Text(
                text = "Get Cash", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 30.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(700),
                    color = Purple50,
                    textAlign = TextAlign.Center,
                )
            )
        }

    }
}






