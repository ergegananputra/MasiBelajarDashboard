package com.sic6.masibelajar.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sic6.masibelajar.ui.navigation.graphs.AuthGraph.SignIn.authGraph
import com.sic6.masibelajar.ui.navigation.graphs.FeatureGraph.Fullscreen.featureGraph
import kotlinx.serialization.Serializable

@Serializable
sealed class RootGraph {
    @Serializable
    data object Auth : RootGraph()

    @Serializable
    data object Main : RootGraph()

    companion object {
        @Composable
        fun RootNavHost(navController: NavHostController) {
            NavHost(navController = navController, startDestination = Auth) {
                authGraph(navController)
                featureGraph(navController)
            }
        }
    }
}