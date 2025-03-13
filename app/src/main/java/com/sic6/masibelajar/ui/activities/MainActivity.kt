package com.sic6.masibelajar.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sic6.masibelajar.ui.screens.auth.SignInScreen
import com.sic6.masibelajar.ui.screens.auth.SignUpScreen
import com.sic6.masibelajar.ui.screens.dashboard.DashboardScreen
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasiBelajarDashboardTheme {
                Surface {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "sign_in") {
                        composable("sign_in") { SignInScreen(navController) }
                        composable("sign_up") { SignUpScreen(navController) }
                        composable("dashboard") { DashboardScreen() }
                    }
                }
            }

        }
    }
}
