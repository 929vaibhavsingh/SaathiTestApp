@file:OptIn(ExperimentalMaterial3Api::class)

package com.saathi.features.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.features.theme.DarkBlue
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.YellowButtonGradientBrush

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        containerColor = Purple50,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        UpiBottomSheet()
    }
}

@Composable
fun UpiBottomSheet() {
    val isError = false
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Enter your UPI ID",
            style = TextStyle(
                fontSize = 24.sp,

                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                color = Color.White,

                )
        )

        Text(
            text = "₹500 will be transferred to this UPI ID",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(500),
                color = Color.White,

                )
        )

        TextFieldM(isError)

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(brush = YellowButtonGradientBrush),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        ) {

            Text(
                text = "Verify", style = TextStyle(
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


@Composable
fun TextFieldWithIcons(isError: Boolean) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        isError = isError,
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(color = DarkBlue),
        placeholder = {
            Text(
                text = "Enter UPI ID", color = Color.White
            )
        },

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldM(isError: Boolean) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return TextField(
        modifier = Modifier.fillMaxWidth(),
        isError = isError,
        value = text,
        textStyle = TextStyle(
            color = Color.White,
        ),

        colors = TextFieldDefaults.textFieldColors(
            containerColor = DarkBlue,
            cursorColor = Color.White,
            errorTextColor = Color.Red,
            disabledLabelColor = Color.Gray,
            unfocusedTextColor = Color.White
        ),
        onValueChange = {
            text = it
        },
        placeholder = {
            Text(
                text = "Enter UPI ID", color = Color.White
            )
        },
        shape = RoundedCornerShape(8.dp),
        singleLine = true,

        )
}

@Preview
@Composable
fun SaathiApp() {
    UpiBottomSheet()
}

