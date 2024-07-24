package com.saathi.features.features.referrals.viewstate

import com.saathi.domain.model.Referral

sealed interface ReferralViewState {
    object Idle : ReferralViewState
    object Loading : ReferralViewState
    data class Error(val message: String) : ReferralViewState
    data class Success(val referral: Referral?) : ReferralViewState
}