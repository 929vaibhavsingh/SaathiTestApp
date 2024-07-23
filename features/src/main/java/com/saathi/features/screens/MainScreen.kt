package com.saathi.features.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saathi.features.R
import com.saathi.features.model.TabBarItem
import com.saathi.features.theme.BlueScreenGradient2
import com.saathi.features.theme.DarkBlue
import com.saathi.features.theme.Purple40
import com.saathi.features.theme.Purple50


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(mainNavController: NavHostController) {
    val trainingTab = TabBarItem(
        title = "Training",
        selectedIcon = painterResource(id = R.drawable.ic_training),
        unselectedIcon = painterResource(id = R.drawable.ic_training)
    )
    val certificatesTab = TabBarItem(
        title = "Certificates",
        selectedIcon = painterResource(id = R.drawable.ic_certificates),
        unselectedIcon = painterResource(id = R.drawable.ic_certificates),
    )
    val trueIdTab = TabBarItem(
        title = "True ID",
        selectedIcon = painterResource(id = R.drawable.ic_true_id),
        unselectedIcon = painterResource(id = R.drawable.ic_true_id)
    )
    val referTab = TabBarItem(
        title = "Refer & Earn",
        selectedIcon = painterResource(id = R.drawable.ic_refer_unselected),
        unselectedIcon = painterResource(id = R.drawable.ic_refer_unselected)
    )

    // creating a list of all the tabs
    val tabBarItems = listOf(trainingTab, certificatesTab, trueIdTab, referTab)

    // creating our navController
    val navController = rememberNavController()

    // A surface container using the 'background' color from the theme
    Surface(

        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Scaffold(

            bottomBar = { TabView(tabBarItems, navController) }, containerColor = DarkBlue,
        ) {
            NavHost(navController = navController, startDestination = trainingTab.title) {
                composable(trainingTab.title) {
                    Text(trainingTab.title)
                }
                composable(certificatesTab.title) {
                    Text(certificatesTab.title)
                }
                composable(trueIdTab.title) {
                    Text(trueIdTab.title)
                }
                composable(referTab.title) {
                    ReferAndEarn(mainNavController)
                }
            }
        }
    }
}


@Composable
fun TabView(tabBarItems: List<TabBarItem>, navController: NavController) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column {
        Divider(
            color = Purple50, modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
        )
        BottomAppBar(
            containerColor = DarkBlue

        ) {
            // looping over each tab to generate the views and navigation for each item
            tabBarItems.forEachIndexed { index, tabBarItem ->
                NavigationBarItem(
                    colors = NavigationBarItemDefaults
                        .colors(
                            indicatorColor = BlueScreenGradient2,

                            ),
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        navController.navigate(tabBarItem.title)
                    },

                    icon = {
                        TabBarIconView(
                            isSelected = selectedTabIndex == index,
                            selectedIcon = tabBarItem.selectedIcon,
                            unselectedIcon = tabBarItem.unselectedIcon,
                            title = tabBarItem.title,
                        )
                    },
                    label = {
                        Text(
                            tabBarItem.title,
                            color = if (selectedTabIndex == index) Color.White else Purple40
                        )
                    })


            }
        }
    }
}


@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: Painter,
    unselectedIcon: Painter,
    title: String,

    ) {
    Icon(
        painter = if (isSelected) {
            selectedIcon
        } else {
            unselectedIcon
        },
        tint = if (isSelected) {
            Color.White
        } else {
            Purple40
        },
        contentDescription = title,
    )
}