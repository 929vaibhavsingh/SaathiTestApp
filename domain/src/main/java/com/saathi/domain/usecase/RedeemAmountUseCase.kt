package com.saathi.domain.usecase

import com.saathi.domain.model.RedeemAmountRequest
import com.saathi.domain.repository.WalletRepository
import javax.inject.Inject

class RedeemAmountUseCase @Inject constructor(private val walletRepository: WalletRepository) {
    suspend operator fun invoke(redeemAmountRequest: RedeemAmountRequest) = walletRepository.redeemAmount(redeemAmountRequest)
}
