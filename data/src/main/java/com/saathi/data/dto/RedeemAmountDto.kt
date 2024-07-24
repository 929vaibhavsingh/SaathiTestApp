package com.saathi.data.dto

import com.google.gson.annotations.SerializedName

data class RedeemAmountResponse(
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("version") var version: String? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("data") var data: RedeemAmountDto = RedeemAmountDto()
)

data class RedeemAmountDto(
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("recordStatus") var recordStatus: Int? = null,
    @SerializedName("referees") var referees: ArrayList<RefereesDto> = arrayListOf(),
    @SerializedName("rewards") var rewards: ArrayList<RewardsDto> = arrayListOf(),
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null,
    @SerializedName("referrerUserId") var referrerUserId: String? = null,
    @SerializedName("referralCode") var referralCode: String? = null,
    @SerializedName("referralLink") var referralLink: String? = null,
    @SerializedName("__v") var _v: Int? = null,
    @SerializedName("paymentStatus") var paymentStatus: String? = null,
    @SerializedName("upiId") var upiId: String? = null,
    @SerializedName("referralAmountSent") var referralAmountSent: Int? = null

)

data class RefereesDto(

    @SerializedName("refereeUserId") var refereeUserId: String? = null,
    @SerializedName("signUpStatus") var signUpStatus: String? = null,
    @SerializedName("coursePurchaseStatus") var coursePurchaseStatus: String? = null,
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("updatedAt") var updatedAt: String? = null

)

data class RewardsDto(

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