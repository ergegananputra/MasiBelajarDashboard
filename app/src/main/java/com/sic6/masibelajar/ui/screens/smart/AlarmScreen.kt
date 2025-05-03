package com.sic6.masibelajar.ui.screens.smart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Face4
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sic6.masibelajar.R
import com.sic6.masibelajar.ui.screens.dashboard.VideoStreamViewModel
import com.sic6.masibelajar.ui.screens.smart.camera.CameraViewModel
import com.sic6.masibelajar.ui.screens.smart.components.LabeledTextField

@Preview(showBackground = true)
@Composable
private fun AlarmScreenPreview() {
    AlarmScreen(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    videoStreamViewModel: VideoStreamViewModel = viewModel(),
    cameraViewModel: CameraViewModel = viewModel()
) {
    var waitTime by remember { mutableStateOf("3000") }
    var fallDetection by remember { mutableStateOf(false) }
    var safezoneDetection by remember { mutableStateOf(true) }
    var targetClass by remember { mutableStateOf("Toddler") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Alarm Config",
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Back")
                    }
                },
                actions = {
                    Button(
                        onClick = { /* Save action */ },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Save")
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            LabeledTextField(
                label = "Notification Wait Time (seconds)",
                value = waitTime,
                onValueChange = { waitTime = it },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Alarm Active",
                style = MaterialTheme.typography.titleMedium
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Fall Detection")
                Spacer(modifier = Modifier.weight(1f))
                Switch(checked = fallDetection, onCheckedChange = { fallDetection = it })
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Safezone Detection")
                Spacer(modifier = Modifier.weight(1f))
                Switch(checked = safezoneDetection, onCheckedChange = { safezoneDetection = it })
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Target Class",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    onClick = { targetClass = "Toddler" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (targetClass == "Toddler") Color.Gray else Color.LightGray
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.ChildCare, contentDescription = "Toddler")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Toddler")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { targetClass = "Non-Toddler" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (targetClass == "Non-Toddler") Color.Gray else Color.LightGray
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Face4, contentDescription = "Toddler")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Non Toddler")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Share Notification",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                // Placeholder images. Replace with actual image loading in production.
                listOf("Adiel", "Marwah").forEach { name ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.ic_lokari_2), // Replace with actual image
                            contentDescription = name,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                        )
                        Text(name, fontSize = 12.sp)
                    }
                }

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceContainer,
                            shape = CircleShape
                        )
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outlineVariant,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add User",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
