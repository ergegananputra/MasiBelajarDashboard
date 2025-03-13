package com.sic6.masibelajar.ui.navigation.menus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material.icons.twotone.MenuBook
import androidx.compose.ui.graphics.vector.ImageVector
import com.sic6.masibelajar.ui.navigation.graphs.MainGraph

sealed class MainNavigationMenu(val name: String, val route: MainGraph, val icon: ImageVector, val iconSelected: ImageVector) {

    data object Monitoring : MainNavigationMenu("Monitoring", MainGraph.Monitoring, Icons.Outlined.Videocam, Icons.Rounded.Videocam)
    data object Article : MainNavigationMenu("Article", MainGraph.Article, Icons.TwoTone.MenuBook, Icons.Filled.MenuBook)
    data object Setting : MainNavigationMenu("Setting", MainGraph.Setting, Icons.Outlined.Settings, Icons.Rounded.Settings)

    companion object {
        val menus = listOf(Monitoring, Article, Setting)
    }
}