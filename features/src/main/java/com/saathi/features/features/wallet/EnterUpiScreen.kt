@file:OptIn(ExperimentalMaterial3Api::class)

package com.saathi.features.features.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.common.di.ValidationUtils
import com.saathi.domain.model.RedeemAmountRequest
import com.saathi.features.features.wallet.intent.WalletIntent
import com.saathi.features.features.wallet.viewmodel.WalletViewModel
import com.saathi.features.features.wallet.viewstate.RedeemAmountViewState
import com.saathi.features.features.wallet.viewstate.UPIFieldState
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.YellowButtonGradientBrush

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    viewModel: WalletViewModel,
    onDismiss: () -> Unit,
    processPayment: (isSuccess: Boolean) -> Unit
) {
    val state by viewModel.redeemAmountDataState.collectAsState(initial = RedeemAmountViewState.Idle)
//    val state by viewModel.verifyUpiDataState.collectAsState(initial = VerifyUpiViewState.Idle)
    var isShowPaymentProcessingDialog by remember { mutableStateOf(false) }
    var isShowPaymentSuccessDialog by remember { mutableStateOf(false) }

    if (isShowPaymentProcessingDialog) {
        LoadPaymentProcessingDialog()
    }
    if (isShowPaymentSuccessDialog) {
        LoadSuccessPaymentDialog {
            isShowPaymentSuccessDialog = false
            onDismiss.invoke()
        }
    }

    when (state) {
        is RedeemAmountViewState.Loading -> {
            isShowPaymentProcessingDialog = true
        }

        is RedeemAmountViewState.Success -> {
            isShowPaymentProcessingDialog = true
            isShowPaymentSuccessDialog = true
        }

        is RedeemAmountViewState.Error -> {
            isShowPaymentProcessingDialog = false
            processPayment(false)
        }

        else -> {}
    }
    val modalBottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        containerColor = Purple50,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        UpiBottomSheet(viewModel)
    }
}


@Composable
fun UpiBottomSheet(viewModel: WalletViewModel) {
    val isError = false
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var textState: UPIFieldState by remember { mutableStateOf(UPIFieldState.IDLE) }
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

        TextFieldM(text = text, textState) {
            text = it
            textState =
                if (it.text.isEmpty()) {
                    UPIFieldState.FOCUSSED
                } else if (ValidationUtils.isValidUpiId(it.text)) {
                    UPIFieldState.SUCCESS
                } else if (!ValidationUtils.isValidUpiId(it.text)) {
                    UPIFieldState.ERROR
                } else {
                    UPIFieldState.FOCUSSED
                }
        }

        VerifyButton("Verify") {
            viewModel.sendIntent(
                WalletIntent.RedeemAmount(
                    RedeemAmountRequest(
                        "669a1a48ed716df191be88aa",/*text.text*/
                        "7004617522@upi"
                    )
                )
            )
        }
    }
}

@Composable
private fun VerifyButton(buttonText: String, onClick: () -> Unit) {
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(brush = YellowButtonGradientBrush),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    ) {

        Text(
            text = buttonText, style = TextStyle(
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldM(
    text: TextFieldValue,
    textState: UPIFieldState,
    onEmailChange: (data: TextFieldValue) -> Unit
) {

    return OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        textStyle = TextStyle(
            color = Color.White,
        ),
        trailingIcon ={
            Icon(imageVector = when (textState) {
                UPIFieldState.ERROR -> Color.Red
                UPIFieldState.SUCCESS -> Color.Green
                UPIFieldState.FOCUSSED -> Color.White
                else -> Color.White
            }, contentDescription = "Email Icon", tint = Color.White)
        },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = when (textState) {
                UPIFieldState.ERROR -> Color.Red
                UPIFieldState.SUCCESS -> Color.Green
                UPIFieldState.FOCUSSED -> Color.White
                else -> Color.White
            },
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.White,
        ),
        onValueChange = {
            onEmailChange(it)
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

