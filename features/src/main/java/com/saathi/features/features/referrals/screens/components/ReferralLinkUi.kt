package com.saathi.features.features.referrals.screens.components

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.PurpleTextGradientBrush
import com.saathi.features.theme.PurpleTextShadow
import com.saathi.features.theme.TextPurpleGradient1
import com.saathi.features.theme.YellowButtonGradientBrush

@Composable
fun ReferralLinkUi(
    onClickRefer: () -> Unit,
    onClickTermsCondition: () -> Unit,
    onClickFaq: () -> Unit
) {
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
            Text(
                text = stringResource(R.string.your_referral_link).uppercase(),
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight(700),
                    brush = PurpleTextGradientBrush,
                    shadow = PurpleTextShadow,
                    textAlign = TextAlign.Center,
                )
            )
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

                    .padding(start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "saathi.in/kishanpatil",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_copy), // Replace with your image resource
                    contentDescription = "Background image",
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsapp), // Replace with your image resource
                    contentDescription = "Whatsapp image",
                )
                Image(
                    painter = painterResource(id = R.drawable.facebook), // Replace with your image resource
                    contentDescription = "facebook  image",
                )

                Button(
                    onClick = {
                    onClickRefer.invoke()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(brush = YellowButtonGradientBrush)
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_rupees), // Replace with your image resource
                        contentDescription = stringResource(R.string.next),
                    )
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = stringResource(R.string.refer_earn),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 30.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight(800),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                    )

                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp),
                color = Purple50
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.background(
                    color = DarkBlue40,
                    shape = RoundedCornerShape(size = 12.dp)
                )


            ) {
                TermsAndCondition(onClickTermsCondition)
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                        .padding(start = 16.dp, end = 16.dp),
                    color = Purple50
                )
                Faq(onClickFaq)

            }
            Spacer(modifier = Modifier.height(100.dp))

        }

    }
}
