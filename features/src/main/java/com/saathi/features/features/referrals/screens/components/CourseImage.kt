package com.saathi.features.features.referrals.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saathi.features.R

@Composable
fun CourseImage() {
    Image(
        modifier = Modifier
            .width(343.dp)
            .height(170.dp),
        painter = painterResource(id = R.drawable.rectangle_user),
        contentDescription = "image description",
        contentScale = ContentScale.FillBounds
    )
}
