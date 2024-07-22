package com.saathi.data.dto

import com.google.gson.annotations.SerializedName


data class VerifyUpiDto(
    @SerializedName("status") var status: String? = null,
    @SerializedName("vpa") var vpa: String? = null,
    @SerializedName("mandate_details") var mandateDetails: MandateDetailsDto? = MandateDetailsDto(),
    @SerializedName("customer_name") var customerName: String? = null

)


data class MandateDetailsDto(
    @SerializedName("is_handle_supported") var isHandleSupported: Boolean? = null

)