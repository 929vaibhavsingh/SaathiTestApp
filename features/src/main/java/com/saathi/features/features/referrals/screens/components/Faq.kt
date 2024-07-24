package com.saathi.features.features.referrals.screens.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.features.R

@Composable
fun Faq(onClickFaq: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp).clickable {
            onClickFaq.invoke()
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_faq), // Replace with your image resource
            contentDescription = "Background image",
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            text = "FAQs",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                )
        )
        Image(
            painter = painterResource(id = R.drawable.ic_next_arrow), // Replace with your image resource
            contentDescription = "Background image",
        )

    }
}