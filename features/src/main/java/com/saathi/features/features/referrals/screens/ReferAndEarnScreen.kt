package com.saathi.features.features.referrals.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.saathi.common.Utils
import com.saathi.features.component.CircularProgressDialog
import com.saathi.features.constants.Screen
import com.saathi.features.features.referrals.intent.ReferralIntent
import com.saathi.features.features.referrals.screens.components.ReferAndEarnUi
import com.saathi.features.theme.Purple50
import com.saathi.features.features.referrals.viewmodel.ReferAndEarnViewModel
import com.saathi.features.features.referrals.viewstate.ReferralViewState


@Composable
fun ReferAndEarn(
    mainNavController: NavHostController,
    viewModel: ReferAndEarnViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state by viewModel.referralDataState.collectAsStateWithLifecycle(initialValue = ReferralViewState.Idle)
    var isDialogVisible by remember { mutableStateOf(false) }

    LaunchedEffect(state) {
        when (state) {
            is ReferralViewState.Loading -> isDialogVisible = true
            is ReferralViewState.Success -> {
                val link = (state as ReferralViewState.Success).referral?.data?.referralMediaLink
                Utils.shareCourse(link, context)
                isDialogVisible = false

            }

            is ReferralViewState.Error -> isDialogVisible = false
            else -> Unit
        }
    }

    CircularProgressDialog(
        isVisible = isDialogVisible,
        onDismiss = { isDialogVisible = false }
    )

    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(color = Purple50)
            .fillMaxSize()
    ) {
        ReferAndEarnUi(
            onClickWallet = { mainNavController.navigate(Screen.GetCashScreen.route) },
            onClickRefer = { viewModel.sendIntent(ReferralIntent.GetReferral) },
            onClickTermsCondition = { mainNavController.navigate(Screen.TermsAndConditionScreen.route) },
            onClickFaq = { mainNavController.navigate(Screen.TermsAndConditionScreen.route) }
        )
    }
}




