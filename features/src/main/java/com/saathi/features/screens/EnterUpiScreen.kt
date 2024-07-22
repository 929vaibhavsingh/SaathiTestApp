package com.saathi.features.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
 import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.features.theme.BlueScreenGradientBrush
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.YellowButtonGradientBrush

//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun UpiScreen(
//    onDismiss: () -> Unit,
//    sheetState: SheetState,
//) {
//    ModalBottomSheet(
//        onDismissRequest = onDismiss,
//        sheetState = sheetState,
//        containerColor = Color.Transparent,
//        contentColor = MaterialTheme.colorScheme.onSurface,
//        shape = RectangleShape,
//        dragHandle = null,
//        scrimColor = Color.Black.copy(alpha = .5f),
//        windowInsets = WindowInsets(0, 0, 0, 0)
//    ) {
//        UpiBottomSheet()
//    }
//
//}
//
//@Composable
//fun UpiBottomSheet() {
//    Column(
//        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
//        horizontalAlignment = Alignment.Start,
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(brush = BlueScreenGradientBrush)
//    ) {
//        Text(
//            text = "Enter your UPI ID",
//            style = TextStyle(
//                fontSize = 24.sp,
//                lineHeight = 36.sp,
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight(700),
//                color = Color.White,
//
//                )
//        )
//
//        Text(
//            text = "₹500 will be transferred to this UPI ID",
//            style = TextStyle(
//                fontSize = 14.sp,
//                lineHeight = 21.sp,
//                fontFamily = FontFamily.Default,
//                fontWeight = FontWeight(500),
//                color = Color.White,
//
//                )
//        )
//        TextFieldWithIcons()
//
//        Button(
//            onClick = { },
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(shape = RoundedCornerShape(10.dp))
//                .background(brush = YellowButtonGradientBrush),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
//        ) {
//
//            Text(
//                text = "Verify", style = TextStyle(
//                    fontSize = 16.sp,
//                    lineHeight = 30.sp,
//                    fontFamily = FontFamily.Default,
//                    fontWeight = FontWeight(700),
//                    color = Purple50,
//                    textAlign = TextAlign.Center,
//                )
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TextFieldWithIcons() {
//    var text by remember { mutableStateOf(TextFieldValue("")) }
//    return OutlinedTextField(
//        value = text,
//        onValueChange = {
//            text = it
//        },
//        modifier = Modifier.fillMaxWidth(),
//        label = { Text(text = "Enter UPI ID") },
//        placeholder = { Text(text = "Enter your e-mail") },
//    )
//}
//
