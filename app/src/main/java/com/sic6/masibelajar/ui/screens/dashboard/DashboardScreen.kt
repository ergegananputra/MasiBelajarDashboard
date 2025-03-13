package com.sic6.masibelajar.ui.screens.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sic6.masibelajar.ui.navigation.graphs.MainGraph
import com.sic6.masibelajar.ui.screens.dashboard.components.AppBottomNavigation
import com.sic6.masibelajar.ui.screens.dashboard.components.AppTopBar
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun DashboardScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        DashboardScreen()
    }
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppTopBar(navController) },
        bottomBar = { AppBottomNavigation(navController) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        MainGraph.DashboardNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
