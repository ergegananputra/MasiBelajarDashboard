package com.sic6.masibelajar.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sic6.masibelajar.ui.screens.article.ArticleScreen
import com.sic6.masibelajar.ui.screens.monitoring.MonitoringScreen
import com.sic6.masibelajar.ui.screens.setting.SettingScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class MainGraph {

    @Serializable
    data object Monitoring : MainGraph()

    @Serializable
    data object Article : MainGraph()

    @Serializable
    data object Setting : MainGraph()

    companion object {
        @Composable
        fun DashboardNavHost(
            navController: NavHostController,
//            eventHandler : (MainGraph) -> Unit,
            modifier: Modifier = Modifier
        ) {
            NavHost(
                navController = navController,
                startDestination = Monitoring
            ) {
                composable<Monitoring> {
                    MonitoringScreen(
                        modifier = modifier
                    )
                }
                composable<Article> {
                    ArticleScreen(
                        modifier = modifier
                    )
                }
                composable<Setting> {
                    SettingScreen(
                        modifier = modifier
                    )
                }
            }
        }
    }
}