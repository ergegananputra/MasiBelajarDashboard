package com.sic6.masibelajar.ui.screens.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

}