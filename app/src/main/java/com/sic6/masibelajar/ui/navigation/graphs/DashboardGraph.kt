package com.sic6.masibelajar.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sic6.masibelajar.ui.screens.dashboard.WebSocketViewModel
import com.sic6.masibelajar.ui.screens.home.HomeScreen
import com.sic6.masibelajar.ui.screens.monitoring.HistoryScreen
import com.sic6.masibelajar.ui.screens.setting.SettingScreen
import com.sic6.masibelajar.ui.screens.smart.AlarmScreen
import com.sic6.masibelajar.ui.screens.smart.CameraScreen
import com.sic6.masibelajar.ui.screens.smart.SmartSettingScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class DashboardGraph {

    @Serializable
    data object Home : DashboardGraph()

    @Serializable
    data object Smart : DashboardGraph()

    @Serializable
    data object Camera : DashboardGraph()

    @Serializable
    data object Alarm : DashboardGraph()

    @Serializable
    data object History : DashboardGraph()

    @Serializable
    data object Setting : DashboardGraph()

    companion object {
        @Composable
        fun DashboardNavHost(
            navController: NavHostController,
            parentNavController: NavHostController,
//            eventHandler : (DashboardGraph) -> Unit,
            modifier: Modifier = Modifier,
            viewModel: WebSocketViewModel = viewModel()
        ) {
            NavHost(
                navController = navController,
                startDestination = Home
            ) {
                composable<Home> {
                    HomeScreen(
                        navController = parentNavController,
                        viewModel = viewModel,
                        modifier = modifier
                    )
                }
                composable<Smart> {
                    SmartSettingScreen(
                        navController = navController,
                        modifier = modifier
                    )
                }
                composable<Camera> {
                    CameraScreen(
                        navController = navController,
                        viewModel = viewModel,
                        modifier = modifier
                    )
                }
                composable<Alarm> {
                    AlarmScreen(
                        navController = navController,
                        viewModel = viewModel,
                        modifier = modifier
                    )
                }
                composable<History> {
                    HistoryScreen(
                        viewModel = viewModel,
                        modifier = modifier
                    )
                }
                composable<Setting> {
                    SettingScreen(
                        modifier = modifier,
                        navController = navController,
                    )
                }
            }
        }
    }
}