package com.sic6.masibelajar.ui.screens.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
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
private fun SettingScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        SettingScreen()
    }
}


@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text("Setting Screen")
    }
}