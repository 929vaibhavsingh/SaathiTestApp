package com.saathi.data.di

import com.saathi.data.repository.ReferralRepositoryImp
import com.saathi.data.repository.WalletRepositoryImp
import com.saathi.domain.repository.ReferralRepository
import com.saathi.domain.repository.WalletRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindWalletRepository(
        walletRepository: WalletRepositoryImp
    ): WalletRepository
    @Binds
    abstract fun bindReferralRepository(
        referralRepository: ReferralRepositoryImp
    ): ReferralRepository
}

