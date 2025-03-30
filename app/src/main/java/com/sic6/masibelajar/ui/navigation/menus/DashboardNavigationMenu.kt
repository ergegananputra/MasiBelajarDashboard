package com.sic6.masibelajar.ui.navigation.menus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material.icons.twotone.MenuBook
import androidx.compose.ui.graphics.vector.ImageVector
import com.sic6.masibelajar.ui.navigation.graphs.DashboardGraph

sealed class DashboardNavigationMenu(val name: String, val route: DashboardGraph, val icon: ImageVector, val iconSelected: ImageVector) {

    data object Monitoring : DashboardNavigationMenu("Monitoring", DashboardGraph.Monitoring, Icons.Outlined.Videocam, Icons.Rounded.Videocam)
    data object Article : DashboardNavigationMenu("Article", DashboardGraph.Article, Icons.TwoTone.MenuBook, Icons.Filled.MenuBook)
    data object Setting : DashboardNavigationMenu("Setting", DashboardGraph.Setting, Icons.Outlined.Settings, Icons.Rounded.Settings)

    companion object {
        val menus = listOf(Monitoring, Article, Setting)
    }
}