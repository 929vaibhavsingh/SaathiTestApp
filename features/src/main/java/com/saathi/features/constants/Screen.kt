package com.saathi.features.constants

import com.saathi.features.constants.ScreenConstants.FAQ_SCREEN
import com.saathi.features.constants.ScreenConstants.GET_CASH_SCREEN
import com.saathi.features.constants.ScreenConstants.MAIN_SCREEN
import com.saathi.features.constants.ScreenConstants.PAYMENT_PROCESSING_SCREEN
import com.saathi.features.constants.ScreenConstants.REFER_AND_EARN_SCREEN
import com.saathi.features.constants.ScreenConstants.TERMS_AND_CONDITION


sealed class Screen(val route: String) {
    object MainScreen : Screen(MAIN_SCREEN)
    object ReferAndEarn : Screen(REFER_AND_EARN_SCREEN)
    object GetCashScreen : Screen(GET_CASH_SCREEN)
    object PaymentProcessingScreen : Screen(PAYMENT_PROCESSING_SCREEN)
    object TermsAndConditionScreen : Screen(TERMS_AND_CONDITION)
    object FaqScreen : Screen(FAQ_SCREEN)
}