package com.saathi.data.repository

import com.saathi.domain.model.RedeemAmount
import com.saathi.domain.model.RedeemAmountRequest
import com.saathi.domain.model.Referral
import com.saathi.domain.model.VerifyUpi
import com.saathi.domain.repository.WalletRepository
import com.saathi.domain.result.ApiResult

class WalletRepositoryImp  : WalletRepository {
    override suspend fun referralData(): ApiResult<Referral> {
        TODO("Not yet implemented")
    }

    override suspend fun verifyUPI(): ApiResult<VerifyUpi> {
        TODO("Not yet implemented")
    }

    override suspend fun redeemAmount(redeemAmountRequest: RedeemAmountRequest): ApiResult<RedeemAmount> {
        TODO("Not yet implemented")
    }
}