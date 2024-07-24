package com.saathi.domain.repository

import com.saathi.domain.model.RedeemAmount
import com.saathi.domain.model.RedeemAmountRequest
import com.saathi.domain.model.Referral
import com.saathi.domain.model.ReferralData
import com.saathi.domain.model.VerifyUpi
import com.saathi.domain.result.ApiResult

interface WalletRepository {

    suspend fun verifyUPI(upi:String): ApiResult<VerifyUpi>
    suspend fun redeemAmount(redeemAmountRequest: RedeemAmountRequest): ApiResult<RedeemAmount>
}