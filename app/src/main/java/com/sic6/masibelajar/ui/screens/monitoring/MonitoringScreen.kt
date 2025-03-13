package com.sic6.masibelajar.ui.screens.monitoring

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BrowseGallery
import androidx.compose.material.icons.outlined.Fullscreen
import androidx.compose.material.icons.outlined.HideImage
import androidx.compose.material.icons.outlined.NotificationsActive
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.ScreenshotMonitor
import androidx.compose.material.icons.outlined.SlowMotionVideo
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.sic6.masibelajar.R
import com.sic6.masibelajar.ui.screens.components.CircleBackground
import com.sic6.masibelajar.ui.screens.monitoring.components.MenuButton
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme
import com.sic6.masibelajar.ui.theme.interFontFamily

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun MonitoringScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        MonitoringScreen()
    }
}

@Composable
fun MonitoringScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column {
            // Video stream placeholder ---
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.surfaceContainerHighest)
            ) {
                Text(
                    text = "CAM 1",
                    modifier = Modifier.padding(8.dp)
                )
            }
            // ---

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(monitoringMenus) { menu ->
                    MenuButton(
                        name = menu.first,
                        icon = menu.second,
                    )
                }
            }
            ElevatedButton(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = MaterialTheme.colorScheme.error,
                    containerColor = MaterialTheme.colorScheme.errorContainer
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Emergency Call",
                        style = MaterialTheme.typography.titleMedium,
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(R.drawable.img_emergency),
                        contentDescription = null,
                        modifier = Modifier
                            .size(72.dp)
                            .padding(top = 8.dp)
                    )
                }
            }
        }

        CircleBackground(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 360.dp)
                .zIndex(-1f)
        )
    }
}

val monitoringMenus = listOf(
    "Switch" to Icons.Outlined.PhotoCamera,
    "Fullscreen" to Icons.Outlined.Fullscreen,
    "Screenshot" to Icons.Outlined.ScreenshotMonitor,
    "Playback" to Icons.Outlined.SlowMotionVideo,
    "History" to Icons.Outlined.BrowseGallery,
    "Screen On" to Icons.Outlined.Videocam,
    "Boundary Off" to Icons.Outlined.HideImage,
    "Alarm" to Icons.Outlined.NotificationsActive
)
