package com.saathi.domain.usecase

import com.saathi.domain.repository.WalletRepository
import javax.inject.Inject

class ReferralUseCase @Inject constructor(private val walletRepository: WalletRepository) {
    suspend operator fun invoke() = walletRepository.referralData()
}
