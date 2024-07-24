package com.saathi.features.features.referrals.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saathi.common.di.IoDispatcher
import com.saathi.domain.result.ApiResult
import com.saathi.domain.usecase.ReferralUseCase
import com.saathi.features.features.referrals.intent.ReferralIntent
import com.saathi.features.features.wallet.intent.WalletIntent
import com.saathi.features.features.referrals.viewstate.ReferralViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReferAndEarnViewModel @Inject constructor(
    private val referralUseCase: ReferralUseCase,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,

    ) : ViewModel() {
    private val _referralState = MutableStateFlow<ReferralViewState>(ReferralViewState.Idle)
    val referralDataState: StateFlow<ReferralViewState> = _referralState.asStateFlow()
    fun sendIntent(intent: ReferralIntent) {
        when (intent) {
            is ReferralIntent.GetReferral -> {
                getReferralData()
            }
        }
    }

    private fun getReferralData() {
        viewModelScope.launch(ioDispatcher) {
            _referralState.emit(ReferralViewState.Loading)
            when (val referralData = referralUseCase()) {
                is ApiResult.Success -> {
                    _referralState.emit(
                        ReferralViewState.Success(
                            referral = referralData.data
                        )
                    )
                }

                is ApiResult.Error -> {
                    _referralState.emit(
                        ReferralViewState.Error(
                            referralData.exception.message ?: "An unexpected error"
                        )
                    )

                }
            }
        }

    }


}