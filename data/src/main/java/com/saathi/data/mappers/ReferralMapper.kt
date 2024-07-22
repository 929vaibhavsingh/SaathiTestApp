package com.saathi.data.mappers

import com.saathi.data.dto.ClientMetaDto
import com.saathi.data.dto.ReferralDataDto
import com.saathi.data.dto.ReferralDto
import com.saathi.data.dto.ReferralRefereesDto
import com.saathi.data.dto.ReferralRewardsDto
import com.saathi.domain.model.ClientMeta
import com.saathi.domain.model.Referral
import com.saathi.domain.model.ReferralData
import com.saathi.domain.model.ReferralReferees
import com.saathi.domain.model.ReferralRewards
import javax.inject.Inject

class ReferralMapper @Inject constructor() {
    fun mapToReferral(dto: ReferralDto): Referral {
        return Referral(
            success = dto.success,
            version = dto.version,
            date = dto.date,
            clientMeta = mapClientMeta(dto.clientMeta),
            data = mapReferralData(dto.data)
        )
    }

    private fun mapClientMeta(dto: ClientMetaDto?): ClientMeta? {
        if (dto == null) return null
        return ClientMeta(
            name = dto.name
        )
    }

    private fun mapReferralData(dto: ReferralDataDto?): ReferralData? {
        if (dto == null) return null
        return ReferralData(
            Id = dto.Id,
            recordStatus = dto.recordStatus,
            referees = mapReferralRefereesList(dto.referees),
            rewards = mapReferralRewardsList(dto.rewards),
            createdAt = dto.createdAt,
            updatedAt = dto.updatedAt,
            referrerUserId = dto.referrerUserId,
            referralCode = dto.referralCode,
            referralLink = dto.referralLink,
            _v = dto._v,
            walletBalance = dto.walletBalance,
            headerAmount = dto.headerAmount,
            referralAmountToBeEarned = dto.referralAmountToBeEarned,
            recommendedUpi = dto.recommendedUpi,
            referralMediaLink = dto.referralMediaLink,
            TnC = dto.TnC,
            FAQs = dto.FAQs
        )
    }

    private fun mapReferralRefereesList(dtos: ArrayList<ReferralRefereesDto>): ArrayList<ReferralReferees> {
        val referees = ArrayList<ReferralReferees>()
        for (dto in dtos) {
            val referee = ReferralReferees(
                refereeUserId = dto.refereeUserId,
                signUpStatus = dto.signUpStatus,
                coursePurchaseStatus = dto.coursePurchaseStatus,
                Id = dto.Id,
                createdAt = dto.createdAt,
                updatedAt = dto.updatedAt
            )
            referees.add(referee)
        }
        return referees
    }

    private fun mapReferralRewardsList(dtos: ArrayList<ReferralRewardsDto>): ArrayList<ReferralRewards> {
        val rewards = ArrayList<ReferralRewards>()
        for (dto in dtos) {
            val reward = ReferralRewards(
                rewardValue = dto.rewardValue,
                paymentStatus = dto.paymentStatus,
                refereeUsers = dto.refereeUsers,
                rewardType = dto.rewardType,
                achivedMileStones = dto.achivedMileStones,
                totalMileStones = dto.totalMileStones,
                milestoneStatus = dto.milestoneStatus,
                rewardStatus = dto.rewardStatus,
                Id = dto.Id,
                createdAt = dto.createdAt,
                updatedAt = dto.updatedAt
            )
            rewards.add(reward)
        }
        return rewards
    }
}