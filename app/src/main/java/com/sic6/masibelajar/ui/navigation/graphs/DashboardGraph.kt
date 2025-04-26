package com.sic6.masibelajar.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sic6.masibelajar.ui.screens.article.ArticleScreen
import com.sic6.masibelajar.ui.screens.monitoring.MonitoringScreen
import com.sic6.masibelajar.ui.screens.setting.SettingScreen
import com.sic6.masibelajar.ui.screens.smart.SmartScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class DashboardGraph {

    @Serializable
    data object Monitoring : DashboardGraph()

    @Serializable
    data object Smart : DashboardGraph()

    @Serializable
    data object Article : DashboardGraph()

    @Serializable
    data object Setting : DashboardGraph()

    companion object {
        @Composable
        fun DashboardNavHost(
            navController: NavHostController,
            parentNavController: NavHostController,
//            eventHandler : (DashboardGraph) -> Unit,
            modifier: Modifier = Modifier
        ) {
            NavHost(
                navController = navController,
                startDestination = Monitoring
            ) {
                composable<Monitoring> {
                    MonitoringScreen(
                        navController = parentNavController,
                        modifier = modifier
                    )
                }
                composable<Smart> {
                    SmartScreen(
                        modifier = modifier
                    )
                }
                composable<Article> {
                    ArticleScreen(
                        onArticleClick = { article ->
                            parentNavController.navigate(
                                FeatureGraph.Read(
                                    title = article.title,
                                    author = article.author,
                                    date = article.date,
                                    content = article.content
                                )
                            )
                        },
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