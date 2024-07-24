package com.saathi.features.features.wallet.viewstate

import com.saathi.domain.model.VerifyUpi

sealed interface VerifyUpiViewState {
    object Idle : VerifyUpiViewState
    object Loading : VerifyUpiViewState
    data class Error(val message: String) : VerifyUpiViewState
    data class Success(val referral: VerifyUpi?) : VerifyUpiViewState
}