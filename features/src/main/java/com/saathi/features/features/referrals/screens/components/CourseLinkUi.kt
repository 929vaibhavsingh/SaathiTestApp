package com.saathi.features.features.referrals.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.features.R
import com.saathi.features.theme.DarkBlue
import com.saathi.features.theme.DarkBlue40
import com.saathi.features.theme.TextPurpleGradient1
import com.saathi.features.theme.YellowButtonGradientBrush

@Composable
fun CourseLinkUi(onPurchase: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = DarkBlue,
        ),
        shape = RoundedCornerShape(topStart = 20f, topEnd = 20f),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(12.dp))
            BlueGradientText(stringResource(R.string.your_referral_link))
            Spacer(Modifier.height(16.dp))
            ReferralStep()
            Spacer(Modifier.height(24.dp))
            Row(

                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = TextPurpleGradient1,
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 5.dp)

                    .background(
                        color = DarkBlue40,
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(end = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    text = stringResource(R.string.your_referral_link_is_locked_start_a_course_to_unlock_it_earn_with_referrals),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_course_lock),
                    contentDescription = stringResource(R.string.your_referral_link_is_locked_start_a_course_to_unlock_it_earn_with_referrals)
                )
            }
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    onPurchase.invoke()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(brush = YellowButtonGradientBrush),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),


                ) {


                Text(
                    text = stringResource(R.string.start_a_course),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 30.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight(700),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right), // Replace with your image resource
                    contentDescription = stringResource(R.string.next),
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
        }

    }
}