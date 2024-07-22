package com.saathi.domain.model

import com.google.gson.annotations.SerializedName


data class Referral(

    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("version") var version: String? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("clientMeta") var clientMeta: ClientMeta? = ClientMeta(),
    @SerializedName("data") var data: ReferralData? = ReferralData()

)

data class ClientMeta(

    @SerializedName("name") var name: String? = null

)

data class ReferralReferees(

    @SerializedName("refereeUserId") var refereeUserId: String? = null,
    @SerializedName("signUpStatus") var signUpStatus: String? = null,
    @SerializedName("coursePurchaseStatus") var coursePurchaseStatus: String? = null,
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null

)

data class ReferralRewards(

    @SerializedName("rewardValue") var rewardValue: Int? = null,
    @SerializedName("paymentStatus") var paymentStatus: String? = null,
    @SerializedName("refereeUsers") var refereeUsers: ArrayList<String> = arrayListOf(),
    @SerializedName("rewardType") var rewardType: String? = null,
    @SerializedName("achivedMileStones") var achivedMileStones: Int? = null,
    @SerializedName("totalMileStones") var totalMileStones: Int? = null,
    @SerializedName("milestoneStatus") var milestoneStatus: String? = null,
    @SerializedName("rewardStatus") var rewardStatus: String? = null,
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null

)

data class ReferralData(

    @SerializedName("_id") var Id: String? = null,
    @SerializedName("recordStatus") var recordStatus: Int? = null,
    @SerializedName("referees") var referees: ArrayList<ReferralReferees> = arrayListOf(),
    @SerializedName("rewards") var rewards: ArrayList<ReferralRewards> = arrayListOf(),
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null,
    @SerializedName("referrerUserId") var referrerUserId: String? = null,
    @SerializedName("referralCode") var referralCode: String? = null,
    @SerializedName("referralLink") var referralLink: String? = null,
    @SerializedName("__v") var _v: Int? = null,
    @SerializedName("walletBalance") var walletBalance: Int? = null,
    @SerializedName("headerAmount") var headerAmount: Int? = null,
    @SerializedName("referralAmountToBeEarned") var referralAmountToBeEarned: Int? = null,
    @SerializedName("recommendedUpi") var recommendedUpi: ArrayList<String> = arrayListOf(),
    @SerializedName("referralMediaLink") var referralMediaLink: String? = null,
    @SerializedName("TnC") var TnC: String? = null,
    @SerializedName("FAQs") var FAQs: String? = null

)