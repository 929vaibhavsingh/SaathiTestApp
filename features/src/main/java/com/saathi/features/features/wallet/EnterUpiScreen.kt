@file:OptIn(ExperimentalMaterial3Api::class)

package com.saathi.features.features.wallet

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saathi.common.ValidationUtils
import com.saathi.domain.model.RedeemAmountRequest
import com.saathi.features.R
import com.saathi.features.component.CircularProgressDialog
import com.saathi.features.features.wallet.intent.WalletIntent
import com.saathi.features.features.wallet.viewmodel.WalletViewModel
import com.saathi.features.features.wallet.viewstate.RedeemAmountViewState
import com.saathi.features.features.wallet.viewstate.UPIFieldState
import com.saathi.features.features.wallet.viewstate.VerifyUpiViewState
import com.saathi.features.theme.DarkBlue
import com.saathi.features.theme.Purple50
import com.saathi.features.theme.YellowButtonGradientBrush
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterUpiBottomSheet(
    viewModel: WalletViewModel,
    onDismiss: () -> Unit,
    onPaymentSuccess: (isSuccess: Boolean) -> Unit
) {
    val state by viewModel.redeemAmountDataState.collectAsState(initial = RedeemAmountViewState.Idle)
    val verifyUpiState by viewModel.verifyUpiDataState.collectAsState(initial = VerifyUpiViewState.Idle)
    val modalBottomSheetState = rememberModalBottomSheetState()

    var isDialogVisible by remember { mutableStateOf(false) }

    var isShowPaymentProcessingDialog by remember { mutableStateOf(false) }

    var isShowPaymentSuccessDialog by remember { mutableStateOf(false) }

    var isUpiVerified by remember { mutableStateOf(false) }

    var upiText by remember { mutableStateOf(TextFieldValue("")) }

    CircularProgressDialog(
        isVisible = isDialogVisible,
        onDismiss = { isDialogVisible = false }
    )

    if (isShowPaymentProcessingDialog) {
        LoadPaymentProcessingDialog()
    }

    if (isShowPaymentSuccessDialog) {
        LoadSuccessPaymentDialog {
            isShowPaymentSuccessDialog = false
            onPaymentSuccess(true)
            onDismiss.invoke()
        }
    }

    when (state) {
        is RedeemAmountViewState.Loading -> isShowPaymentProcessingDialog = true
        is RedeemAmountViewState.Success -> {
            CoroutineScope(Dispatchers.IO).launch {
                delay(TimeUnit.SECONDS.toMillis(3))
                isShowPaymentProcessingDialog = false
                isShowPaymentSuccessDialog = true
            }
        }

        is RedeemAmountViewState.Error -> {
            isShowPaymentProcessingDialog = false
            onPaymentSuccess(false)
        }

        else -> Unit
    }

    when (verifyUpiState) {
        is VerifyUpiViewState.Loading -> isDialogVisible = true
        is VerifyUpiViewState.Success, is VerifyUpiViewState.Error -> {
            isDialogVisible = false
            isUpiVerified = true
        }

        else -> Unit
    }

    ModalBottomSheet(
        containerColor = Purple50,
        onDismissRequest = onDismiss,
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        UpiBottomSheet(
            upiText = upiText,
            isUpiVerified = isUpiVerified,
            onTextChange = { upiText = it },
            onClick = {
                if (ValidationUtils.isValidUpiId(upiText.text)) {
                    val intent = if (isUpiVerified) {
                        WalletIntent.RedeemAmount(
                            RedeemAmountRequest(
                                "669a1a48ed716df191be88aa",
                                "7004617522@upi"
                            )
                        )
                    } else {
                        WalletIntent.VerifyWallet(upiText.text)
                    }
                    viewModel.sendIntent(intent)
                }
            }
        )
    }
}

@Composable
fun UpiBottomSheet(
    upiText: TextFieldValue,
    isUpiVerified: Boolean,
    onTextChange: (TextFieldValue) -> Unit,
    onClick: () -> Unit
) {
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
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        Text(
            text = "₹500 will be transferred to this UPI ID",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        )

        TextFieldM(
            text = upiText,
            textState = textState,
            onEmailChange = {
                onTextChange(it)
                textState = when {
                    it.text.isEmpty() -> UPIFieldState.FOCUSSED
                    ValidationUtils.isValidUpiId(it.text) -> UPIFieldState.SUCCESS
                    else -> UPIFieldState.ERROR
                }
            }
        )

        VerifyButton(
            buttonText = if (isUpiVerified) "Get Cash" else "Verify",
            onClick = onClick
        )
    }
}

@Composable
private fun VerifyButton(buttonText: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(brush = YellowButtonGradientBrush),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = buttonText,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 30.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight(700),
                color = DarkBlue,
                textAlign = TextAlign.Center
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldM(
    text: TextFieldValue,
    textState: UPIFieldState,
    onEmailChange: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().background(color = DarkBlue, RoundedCornerShape(8.dp)),
        value = text,
        textStyle = TextStyle(color = Color.White),
        trailingIcon = {
            if (textState != UPIFieldState.IDLE && textState != UPIFieldState.FOCUSSED) {
                val iconRes = when (textState) {
                    UPIFieldState.ERROR -> R.drawable.ic_upi_wrong
                    UPIFieldState.SUCCESS -> R.drawable.ic_upi_correct
                    else -> R.drawable.ic_upi_correct
                }
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = "UPI Icon",
                    tint = when (textState) {
                        UPIFieldState.ERROR -> Color.Red
                        UPIFieldState.SUCCESS -> Color.Green
                        else -> Color.Green
                    }
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = when (textState) {
                UPIFieldState.ERROR -> Color.Red
                UPIFieldState.SUCCESS -> Color.Green
                UPIFieldState.FOCUSSED -> Color.White
                else -> Color.White
            },
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.White
        ),
        onValueChange = onEmailChange,
        placeholder = {
            Text(text = "Enter UPI ID", color = Color.White)
        },
        shape = RoundedCornerShape(8.dp),
        singleLine = true
    )
}