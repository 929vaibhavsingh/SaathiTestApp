package com.saathi.features.features.referrals.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.saathi.features.constants.Screen
import com.saathi.features.features.referrals.screens.components.ReferAndEarnUi
import com.saathi.features.theme.Purple50
import com.saathi.features.features.referrals.viewmodel.ReferAndEarnViewModel
import com.saathi.features.features.referrals.viewstate.ReferralViewState

@Composable
fun ReferAndEarn(
    mainNavController: NavHostController,
    viewModel: ReferAndEarnViewModel = hiltViewModel()
) {
    val state by viewModel.referralDataState.collectAsState(initial = ReferralViewState.Idle)

    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(color = Purple50)
            .fillMaxSize(),
    ) {
        ReferAndEarnUi(viewModel){
            mainNavController.navigate(Screen.GetCashScreen.route)
        }
    }
}



