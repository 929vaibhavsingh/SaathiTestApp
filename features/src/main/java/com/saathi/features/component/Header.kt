package com.saathi.features.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun Header(title : String , onClickBackButton : ()->Unit) {
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
                .clickable {  onClickBackButton.invoke()}
                .padding(10.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(800),
                color = Color.White
            )
        )
    }
}