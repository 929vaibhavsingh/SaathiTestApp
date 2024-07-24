package com.saathi.data.services

import com.saathi.data.dto.RedeemAmountResponse
import com.saathi.data.dto.ReferralDto
import com.saathi.data.dto.VerifyUpiResponse
import com.saathi.domain.model.RedeemAmountRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("referral/api/V1/referral/")
    suspend fun getReferralData(
        @Query("id") id: String = "669a1a48ed716df191be88aa"
    ): Response<ReferralDto>

    @POST("payment/api/v1/verifyVPA/{upi_id}/")
    suspend fun verifyUpiApi(
        @Path("upi_id") upiId: String,
        @Query("paymentgateway") paymentgateway: String = "juspay"
    ): Response<VerifyUpiResponse>

    @POST("referral/api/V1/referral/reward/checkout")
    suspend fun redeemAmountResponse(
        @Body redeemAmountRequest: RedeemAmountRequest
    ): Response<RedeemAmountResponse>
}