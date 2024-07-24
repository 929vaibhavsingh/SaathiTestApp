package com.saathi.features.features.wallet.intent

import com.saathi.domain.model.RedeemAmountRequest

interface WalletIntent {
    object VerifyWallet : WalletIntent
    data class RedeemAmount(val redeemAmountRequest: RedeemAmountRequest) : WalletIntent
}