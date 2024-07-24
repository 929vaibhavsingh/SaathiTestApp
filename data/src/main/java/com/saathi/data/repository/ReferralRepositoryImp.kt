package com.saathi.data.repository

import com.saathi.data.mappers.ReferralMapper
import com.saathi.data.network.SafeApiCall
import com.saathi.data.services.ApiService
import com.saathi.domain.model.Referral
import com.saathi.domain.repository.ReferralRepository
import com.saathi.domain.result.ApiResult
import javax.inject.Inject

class ReferralRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val referralMapper: ReferralMapper
) : ReferralRepository {
    override suspend fun getReferralData(): ApiResult<Referral> {
        return SafeApiCall.call(
            { apiService.getReferralData() },
            { referralDto -> referralMapper.mapToReferral(referralDto) })

    }
}