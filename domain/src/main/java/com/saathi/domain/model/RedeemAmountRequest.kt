package com.saathi.domain.model

import com.google.gson.annotations.SerializedName


data class RedeemAmountRequest(

    @SerializedName("referrerUserId") var referrerUserId: String? = null,
    @SerializedName("upiId") var upiId: String? = null

)