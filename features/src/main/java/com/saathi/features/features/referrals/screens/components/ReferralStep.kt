package com.saathi.features.features.referrals.screens.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.features.R

@Composable
  fun ReferralStep() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.one), // Replace with your image resource
            contentDescription = stringResource(R.string.step),
        )
        Spacer(Modifier.width(5.dp))
        Text(
            text = stringResource(R.string.invite_your_friends),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),

                )
        )
        Spacer(Modifier.width(5.dp))
        Image(
            painter = painterResource(id = R.drawable.horizontal_line), // Replace with your image resource
            contentDescription = "Background image",
        )
        Spacer(Modifier.width(5.dp))
        Image(
            painter = painterResource(id = R.drawable.two), // Replace with your image resource
            contentDescription = stringResource(R.string.step),
        )
        Spacer(Modifier.width(5.dp))
        Text(
            text = stringResource(R.string.earn_100_everytime),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),

                )
        )
    }
}
