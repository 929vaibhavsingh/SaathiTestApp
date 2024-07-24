package com.saathi.features.features.faq


import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saathi.features.component.Header
import com.saathi.features.theme.BlueScreenGradientBrush

@Composable
fun TermsAndCondition(onClickBackButton: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = BlueScreenGradientBrush
            )
            .padding(16.dp)
    ) {
        Header("Saathi",onClickBackButton)
        Spacer(modifier = Modifier.height(18.dp))
    }
}


