package com.sic6.masibelajar.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sic6.masibelajar.R
import com.sic6.masibelajar.ui.navigation.graphs.FeatureGraph
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
private fun HomeScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        HomeScreen(rememberNavController())
    }
}
@Composable
fun HomeScreen(    navController: NavHostController,
                   modifier: Modifier = Modifier) {
    val sharedUsers = listOf(
        R.mipmap.ic_lokari_2,
        R.mipmap.ic_lokari_3,
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            // Title
            Text(text = "You now watch,", style = MaterialTheme.typography.labelLarge)
            Text(
                text = "Restroom DTEDI Lt.2",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Video View Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(12.dp))
            ) {
                // Here you can add your Video Streaming
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
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Realtime 12:12:00",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button actions
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                ActionButton(title = "Full Screen", icon = Icons.Default.Fullscreen)
                ActionButton(title = "Screenshot", icon = Icons.Default.CameraAlt)
                ActionButton(title = "Playback", icon = Icons.Default.PlayArrow)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Visitor Counts
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                VisitorCard(title = "Adult Visitor", count = 2)
                VisitorCard(title = "Toddler Visitor", count = 4)
            }

            Spacer(modifier = Modifier.height(16.dp))

            SharedUsersSection(sharedUsers = sharedUsers) {
                // TODO: Handle Add User
            }

        }
    }
}

@Composable
fun ActionButton(title: String, icon: ImageVector) {
    ElevatedButton(
        onClick = { /* TODO: Handle click */ },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .size(width = 80.dp, height = 80.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                fontSize = 10.sp,
                maxLines = 1
            )
        }
    }
}

@Composable
fun VisitorCard(title: String, count: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(6.dp)
            .size(width = 140.dp, height = 100.dp) // Ukuran dipaksa tetap
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Text(text = title, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = count.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SharedUsersSection(sharedUsers: List<Int>, onAddUser: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = "Shared Users",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                sharedUsers.forEach {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                            .padding(end = 8.dp)
                    )
                }
            }
            IconButton(
                onClick = onAddUser,
                modifier = Modifier
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.primary, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add User",
                    tint = Color.White
                )
            }
        }
    }
}