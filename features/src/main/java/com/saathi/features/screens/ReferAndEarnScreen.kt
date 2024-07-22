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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.features.R
import com.saathi.features.theme.DarkBlue
import com.saathi.features.theme.Purple40
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.PurpleTextGradientBrush
import com.saathi.features.theme.PurpleTextShadow
import com.saathi.features.theme.TextPurpleGradient1
import com.saathi.features.theme.YellowButtonGradientBrush
import com.saathi.features.theme.YellowTextGradientBrush
import com.saathi.features.theme.YellowTextShadow
import java.util.Locale

@Composable
fun ReferAndEarn() {
    Column(
        modifier = Modifier
            .background(color = Purple50)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(Modifier.height(44.dp))
        Text(
            text = stringResource(R.string.refer_karein_aur).uppercase(Locale.ROOT),
            style = TextStyle(
                brush = PurpleTextGradientBrush,
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily.Default,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                shadow = PurpleTextShadow
            ),
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string._1_000),
            style = TextStyle(
                brush = YellowTextGradientBrush,
                fontSize = 80.sp,
                lineHeight = 80.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                shadow = YellowTextShadow,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.tak_roz_kamayein).uppercase(),

            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                letterSpacing = 1.6.sp,
                brush = YellowTextGradientBrush,
                shadow = YellowTextShadow,
            )
        )
        Spacer(Modifier.height(44.dp))
        Image(
            modifier = Modifier
                .width(343.dp)
                .height(170.dp),
            painter = painterResource(id = R.drawable.rectangle_user),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
        Spacer(Modifier.height(18.dp))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = DarkBlue,
            ),
            shape = RoundedCornerShape(topStart = 20f, topEnd = 20f),
            modifier = Modifier
                .fillMaxWidth()


        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
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
                Spacer(Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = TextPurpleGradient1,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(start = 5.dp)

                        .background(
                            color = Purple50,
                            shape = RoundedCornerShape(topStart = 25f, bottomStart = 25f)
                        )

                        .padding(start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.your_referral_link_is_locked_start_a_course_to_unlock_it_earn_with_referrals),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),

                            )
                    )
                }
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = { },
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
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ReferAndEarn()
}
