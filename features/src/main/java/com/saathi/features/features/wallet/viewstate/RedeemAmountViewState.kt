package com.saathi.features.features.wallet.viewstate

import com.saathi.domain.model.RedeemAmount

sealed interface RedeemAmountViewState {
    object Idle : RedeemAmountViewState
    object Loading : RedeemAmountViewState
    data class Error(val message: String) : RedeemAmountViewState
    data class Success(val redeemAmount: RedeemAmount) : RedeemAmountViewState
}