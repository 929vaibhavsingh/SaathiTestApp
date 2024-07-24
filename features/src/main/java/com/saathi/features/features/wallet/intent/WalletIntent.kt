package com.saathi.features.features.wallet.intent

import com.saathi.domain.model.RedeemAmountRequest

interface WalletIntent {
    data class VerifyWallet(val upi : String) : WalletIntent
    data class RedeemAmount(val redeemAmountRequest: RedeemAmountRequest) : WalletIntent
}