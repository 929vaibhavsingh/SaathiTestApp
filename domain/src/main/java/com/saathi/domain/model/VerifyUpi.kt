package com.saathi.domain.model

import com.google.gson.annotations.SerializedName


data class VerifyUpi(
    @SerializedName("status") var status: String? = null,
    @SerializedName("vpa") var vpa: String? = null,
    @SerializedName("mandate_details") var mandateDetails: MandateDetails? = MandateDetails(),
    @SerializedName("customer_name") var customerName: String? = null

)


data class MandateDetails(
    @SerializedName("is_handle_supported") var isHandleSupported: Boolean? = null

)