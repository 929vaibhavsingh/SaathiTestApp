package com.saathi.data.mappers

import com.saathi.data.dto.RedeemAmountDto
import com.saathi.data.dto.RefereesDto
import com.saathi.data.dto.RewardsDto
import com.saathi.domain.model.RedeemAmount
import com.saathi.domain.model.Referees
import com.saathi.domain.model.Rewards
import javax.inject.Inject

class RedeemAmountMapper @Inject constructor(){

    fun mapToRedeemAmount(dto: RedeemAmountDto): RedeemAmount {
        return RedeemAmount(
            Id = dto.Id,
            recordStatus = dto.recordStatus,
            referees = mapRefereesList(dto.referees),
            rewards = mapRewardsList(dto.rewards),
            createdAt = dto.createdAt,
            updatedAt = dto.updatedAt,
            referrerUserId = dto.referrerUserId,
            referralCode = dto.referralCode,
            referralLink = dto.referralLink,
            _v = dto._v,
            paymentStatus = dto.paymentStatus,
            upiId = dto.upiId,
            referralAmountSent = dto.referralAmountSent
        )
    }

    private fun mapRefereesList(refereesDto: ArrayList<RefereesDto>): ArrayList<Referees> {
        val referees = ArrayList<Referees>()
        for (dto in refereesDto) {
            val referee = Referees(
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

    private fun mapRewardsList(rewardsDto: ArrayList<RewardsDto>): ArrayList<Rewards> {
        val rewards = ArrayList<Rewards>()
        for (dto in rewardsDto) {
            val reward = Rewards(
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