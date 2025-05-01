package com.sic6.masibelajar.ui.screens.smart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sic6.masibelajar.ui.screens.smart.components.LabeledTextField

@Preview(showBackground = true)
@Composable
private fun CameraScreenPreview() {
    CameraScreen(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var ipCamera by remember { mutableStateOf("192.1681.001") }
    var numberOfPoints by remember { mutableStateOf("4") }
    var point1X by remember { mutableStateOf("4") }
    var point1Y by remember { mutableStateOf("4") }
    var point2X by remember { mutableStateOf("") }
    var point2Y by remember { mutableStateOf("") }
    var point3X by remember { mutableStateOf("") }
    var point3Y by remember { mutableStateOf("") }
    var point4X by remember { mutableStateOf("") }
    var point4Y by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Camera Settings",
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            LabeledTextField(
                label = "IP Camera Input",
                value = ipCamera,
                onValueChange = { ipCamera = it },
                modifier = Modifier.fillMaxWidth()
            )
            Column {
                Text(
                    text = "Preview",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_placeholder_camera), // Ganti dengan gambar kamera
//                contentDescription = "Camera Preview",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
                }
            }
            LabeledTextField(
                label = "Number of Points (Minimum 3)",
                value = numberOfPoints,
                onValueChange = { numberOfPoints = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Adjust Points",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium
            )
            PositionTextField(title = "Point 1") {
                LabeledTextField(
                    label = "X Position",
                    value = point1X,
                    onValueChange = { point1X = it },
                    modifier = Modifier.weight(1f)
                )
                LabeledTextField(
                    label = "Y Position",
                    value = point1Y,
                    onValueChange = { point1Y = it },
                    modifier = Modifier.weight(1f),
                )
            }
            PositionTextField(title = "Point 2") {
                LabeledTextField(
                    label = "X Position",
                    value = point2X,
                    onValueChange = { point2X = it },
                    modifier = Modifier.weight(1f)
                )
                LabeledTextField(
                    label = "Y Position",
                    value = point2Y,
                    onValueChange = { point2Y = it },
                    modifier = Modifier.weight(1f),
                )
            }
            PositionTextField(title = "Point 3") {
                LabeledTextField(
                    label = "X Position",
                    value = point3X,
                    onValueChange = { point3X = it },
                    modifier = Modifier.weight(1f)
                )
                LabeledTextField(
                    label = "Y Position",
                    value = point3Y,
                    onValueChange = { point3Y = it },
                    modifier = Modifier.weight(1f),
                )
            }
            PositionTextField(title = "Point 4") {
                LabeledTextField(
                    label = "X Position",
                    value = point4X,
                    onValueChange = { point4X = it },
                    modifier = Modifier.weight(1f)
                )
                LabeledTextField(
                    label = "Y Position",
                    value = point4Y,
                    onValueChange = { point4Y = it },
                    modifier = Modifier.weight(1f),
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun PositionTextField(
    title: String,
    modifier: Modifier = Modifier,
    textFields: @Composable (RowScope.() -> Unit)
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.outline,
            )
            Spacer(modifier = Modifier.width(8.dp))
            HorizontalDivider()
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            textFields()
        }
    }
}
