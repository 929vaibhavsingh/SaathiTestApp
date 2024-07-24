package com.saathi.domain.usecase

import com.saathi.domain.repository.ReferralRepository
import com.saathi.domain.repository.WalletRepository
import javax.inject.Inject

class ReferralUseCase @Inject constructor(private val referralRepository: ReferralRepository) {
    suspend operator fun invoke() = referralRepository.getReferralData()
}
