package com.saathi.data.repository

import com.saathi.data.mappers.RedeemAmountMapper
import com.saathi.data.mappers.ReferralMapper
import com.saathi.data.mappers.VerifyUpiMapper
import com.saathi.data.network.SafeApiCall
import com.saathi.data.services.ApiService
import com.saathi.domain.model.RedeemAmount
import com.saathi.domain.model.RedeemAmountRequest
import com.saathi.domain.model.Referral
import com.saathi.domain.model.VerifyUpi
import com.saathi.domain.repository.WalletRepository
import com.saathi.domain.result.ApiResult
import javax.inject.Inject

class WalletRepositoryImp @Inject constructor(private val apiService: ApiService,
                          private val verifyUpiMapper: VerifyUpiMapper,
                          private val redeemAmountMapper: RedeemAmountMapper
)  : WalletRepository {

    override suspend fun verifyUPI(upi:String): ApiResult<VerifyUpi> {
        return SafeApiCall.call(
            { apiService.verifyUpiApi(upi) },
            { verifyUpi -> verifyUpiMapper.mapToVerifyUpi(verifyUpi.data) })

    }


    override suspend fun redeemAmount(redeemAmountRequest: RedeemAmountRequest): ApiResult<RedeemAmount> {
        return SafeApiCall.call(
            { apiService.redeemAmountResponse(redeemAmountRequest) },
            { redeemAmount -> redeemAmountMapper.mapToRedeemAmount(redeemAmount.data) })
    }
}