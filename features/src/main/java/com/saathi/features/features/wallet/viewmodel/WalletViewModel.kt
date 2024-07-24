package com.saathi.features.features.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saathi.common.di.IoDispatcher
import com.saathi.domain.model.RedeemAmountRequest
import com.saathi.domain.result.ApiResult
import com.saathi.domain.usecase.RedeemAmountUseCase
import com.saathi.domain.usecase.VerifyUpiUseCase
import com.saathi.features.features.wallet.intent.WalletIntent
import com.saathi.features.features.wallet.viewstate.RedeemAmountViewState
import com.saathi.features.features.wallet.viewstate.VerifyUpiViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val verifyUpiUseCase: VerifyUpiUseCase,
    private val redeemAmountUseCase: RedeemAmountUseCase,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,

    ) : ViewModel() {

    private val _verifyUpiState = MutableStateFlow<VerifyUpiViewState>(VerifyUpiViewState.Idle)
    val verifyUpiDataState: StateFlow<VerifyUpiViewState> = _verifyUpiState.asStateFlow()

    private val _redeemAmountState = MutableStateFlow<RedeemAmountViewState>(RedeemAmountViewState.Idle)
    val redeemAmountDataState: StateFlow<RedeemAmountViewState> = _redeemAmountState.asStateFlow()

    fun sendIntent(intent: WalletIntent) {
        when (intent) {
            is WalletIntent.VerifyWallet -> {
                verifyUpi()
            }
            is WalletIntent.RedeemAmount->{
                redeemAmountUpi(intent.redeemAmountRequest)
            }
        }
    }

    private fun verifyUpi() {
        viewModelScope.launch(ioDispatcher) {
            _verifyUpiState.emit(VerifyUpiViewState.Loading)
            when (val referralData = verifyUpiUseCase("")) {
                is ApiResult.Success -> {
                    _verifyUpiState.emit(
                        VerifyUpiViewState.Success(
                            referral = referralData.data
                        )
                    )
                }

                is ApiResult.Error -> {
                    _verifyUpiState.emit(
                        VerifyUpiViewState.Error(
                            referralData.exception.message ?: "An unexpected error"
                        )
                    )

                }
            }
        }

    }

    private fun redeemAmountUpi(redeemAmountRequest: RedeemAmountRequest) {
        viewModelScope.launch(ioDispatcher) {
            _redeemAmountState.emit(RedeemAmountViewState.Loading)
            when (val referralData = redeemAmountUseCase(redeemAmountRequest)) {
                is ApiResult.Success -> {
                    _redeemAmountState.emit(
                        RedeemAmountViewState.Success(
                            redeemAmount = referralData.data
                        )
                    )
                }

                is ApiResult.Error -> {
                    _redeemAmountState.emit(
                        RedeemAmountViewState.Error(
                            referralData.exception.message ?: "An unexpected error"
                        )
                    )

                }
            }
        }

    }


}