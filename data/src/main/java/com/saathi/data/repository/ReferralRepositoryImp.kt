package com.saathi.data.repository

import com.saathi.domain.model.Referral
import com.saathi.domain.repository.ReferralRepository
import com.saathi.domain.result.ApiResult

class ReferralRepositoryImp : ReferralRepository{
    override suspend fun getReferralData(): ApiResult<Referral> {
        TODO("Not yet implemented")
    }
}