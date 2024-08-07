package com.saathi.features.features

import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saathi.features.constants.Screen
import com.saathi.features.features.faq.TermsAndCondition
import com.saathi.features.features.wallet.GetCashScreen
import com.saathi.features.features.wallet.PaymentProcessingScreen
import com.saathi.features.theme.MainActivityTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            MainActivityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(
                            route = Screen.MainScreen.route
                        ) {
                            MainScreen(mainNavController = navController)
                        }
                        composable(
                            route = Screen.GetCashScreen.route
                        ) {

                            GetCashScreen(onDismissUpi = { onBackPressedDispatcher.onBackPressed() }) {
                                onBackPressedDispatcher.onBackPressed()

                            }
                        }
                        composable(
                            route = Screen.PaymentProcessingScreen.route
                        ) {

                        }
                        composable(
                            route = Screen.TermsAndConditionScreen.route
                        ) {
                            TermsAndCondition {
                                onBackPressedDispatcher.onBackPressed()
                            }
                        }
                        composable(
                            route = Screen.FaqScreen.route
                        ) {
                            TermsAndCondition {
                                onBackPressedDispatcher.onBackPressed()
                            }
                        }
                    }
                }
            }

        }
    }

    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        return super.getOnBackInvokedDispatcher()
    }

}
