package com.saathi.data.services

import com.saathi.data.dto.ReferralDto
import com.saathi.data.dto.VerifyUpiDto
import com.saathi.domain.model.RedeemAmountRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WalletService {
    @POST("referral/api/V1/referral/")
    suspend fun getReferralData(
        @Query("id") id: String = "669a1a48ed716df191be88aa"
    ): Response<ReferralDto>

    @POST("payment/api/v1/verifyVPA/{upi_id}/")
    suspend fun verifyUpiApi(
        @Path("upi_id") upiId: String,
        @Query("paymentgateway") paymentgateway: String = "juspay"
    ): Response<VerifyUpiDto>

    @POST("referral/api/V1/referral/reward/checkout")
    suspend fun redeemAmountResponse(
        @Body redeemAmountRequest: RedeemAmountRequest
    ): Response<ReferralDto>
}