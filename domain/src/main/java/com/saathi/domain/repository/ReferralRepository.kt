package com.saathi.domain.repository

import com.saathi.domain.model.Referral
import com.saathi.domain.result.ApiResult

interface ReferralRepository {
    suspend fun getReferralData(): ApiResult<Referral>
}