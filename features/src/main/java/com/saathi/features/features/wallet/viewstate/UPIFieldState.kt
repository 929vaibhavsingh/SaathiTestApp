package com.saathi.features.features.wallet.viewstate


sealed interface UPIFieldState {
    object ERROR : UPIFieldState
    object SUCCESS : UPIFieldState
    object FOCUSSED : UPIFieldState
    object IDLE : UPIFieldState
}