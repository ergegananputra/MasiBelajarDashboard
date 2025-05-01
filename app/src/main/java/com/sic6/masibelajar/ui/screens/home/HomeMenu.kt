package com.sic6.masibelajar.ui.screens.home

import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.SlowMotionVideo
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sic6.masibelajar.R
import com.sic6.masibelajar.domain.entities.VideoStreamRequest
import com.sic6.masibelajar.ui.components.Base64Image
import com.sic6.masibelajar.ui.screens.dashboard.WebSocketViewModel
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun HomeScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        HomeScreen(viewModel = viewModel(), navController = rememberNavController())
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: WebSocketViewModel = viewModel(),
    navController: NavHostController,
) {
    val response by viewModel.response.collectAsState()
    val sharedUsers = listOf(
        R.mipmap.ic_lokari_2,
        R.mipmap.ic_lokari_3,
    )

    LaunchedEffect(Unit) {
        viewModel.send(
            VideoStreamRequest(
                id = "stream_3",
                points = listOf(
                    listOf(0, 0),
                    listOf(0, 2),
                    listOf(2, 2),
                    listOf(2, 0)
                ),
                url = "http://192.168.137.209:81/stream",
                time_threshold = 30,
                preview = true,
                track = true
            )
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 4.dp, bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Now watching",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.outline
                )
                Text(
                    text = "Restroom DTEDI Lt.2",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "info",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        // Video View Placeholder
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .background(MaterialTheme.colorScheme.surfaceContainer, shape = RoundedCornerShape(12.dp))
//                .clip(RoundedCornerShape(8.dp))
//        ) {
//            // Here you can add your Video Streaming
//            Text(
//                text = "CAM 1",
//                modifier = Modifier.padding(8.dp)
//            )
//        }

            response?.let { res ->
                Log.d("websocket", res.data.results.toString())

                Base64Image(
                    base64String = res.data.frame,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Realtime ${res.data.results.timestamp}",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button actions
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                ActionButton(title = "Fullscreen", icon = Icons.Default.Fullscreen, modifier = Modifier.weight(1f))
                ActionButton(title = "Screenshot", icon = Icons.Outlined.CameraAlt, modifier = Modifier.weight(1f))
                ActionButton(title = "Playback", icon = Icons.Default.SlowMotionVideo, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Visitor Counts
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                VisitorCard(title = "Adult Visitor", count = res.data.results.counts.non_toddler, modifier = Modifier.weight(1f))
                VisitorCard(title = "Toddler Visitor", count = res.data.results.counts.toddler, modifier = Modifier.weight(1f))
            }
            }

        Spacer(modifier = Modifier.height(16.dp))

        SharedUsersSection(sharedUsers = sharedUsers) {
            // TODO: Handle Add User
        }

    }
}

@Composable
fun ActionButton(title: String, icon: ImageVector, modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { /* TODO: Handle click */ },
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = title)
        }
    }
}

@Composable
fun VisitorCard(title: String, count: Int, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = count.toString(), style = MaterialTheme.typography.headlineMedium)
        }
    }
}

@Composable
fun SharedUsersSection(sharedUsers: List<Int>, onAddUser: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer,
                shape = RoundedCornerShape(12.dp)
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
//                verticalAlignment = Alignment.CenterVertically
                horizontalArrangement = Arrangement.spacedBy(-8.dp)
            ) {
                sharedUsers.forEach {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surface)
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