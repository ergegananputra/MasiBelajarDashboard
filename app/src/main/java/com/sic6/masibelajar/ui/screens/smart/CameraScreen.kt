package com.sic6.masibelajar.ui.screens.smart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sic6.masibelajar.R

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

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Top bar
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Camera Setting",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = { /* Save action */ },
                enabled = true,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Save")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // IP Camera Input
        Text("IP Camera Input", fontWeight = FontWeight.Medium)
        OutlinedTextField(
            value = ipCamera,
            onValueChange = { ipCamera = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Preview
        Text("Preview", fontWeight = FontWeight.Medium)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray)
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_placeholder_camera), // Ganti dengan gambar kamera
//                contentDescription = "Camera Preview",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Number of Points
        Text("Number of Points (Minimum 3)", fontWeight = FontWeight.Medium)
        OutlinedTextField(
            value = numberOfPoints,
            onValueChange = { numberOfPoints = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Adjust Sensor Points
        Text("Adjust Censor Points", fontWeight = FontWeight.Medium)

        Text("Point 1")
        Row {
            OutlinedTextField(
                value = point1X,
                onValueChange = { point1X = it },
                label = { Text("X Position") },
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                singleLine = true
            )
            OutlinedTextField(
                value = point1Y,
                onValueChange = { point1Y = it },
                label = { Text("Y Position") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Point 2")
        Row {
            OutlinedTextField(
                value = point2X,
                onValueChange = { point2X = it },
                label = { Text("X Position") },
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                singleLine = true
            )
            OutlinedTextField(
                value = point2Y,
                onValueChange = { point2Y = it },
                label = { Text("Y Position") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }

        Text("Point 3")
        Row {
            OutlinedTextField(
                value = point3X,
                onValueChange = { point3X = it },
                label = { Text("X Position") },
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                singleLine = true
            )
            OutlinedTextField(
                value = point3Y,
                onValueChange = { point3Y = it },
                label = { Text("Y Position") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }

        Text("Point 4")
        Row {
            OutlinedTextField(
                value = point4X,
                onValueChange = { point4X = it },
                label = { Text("X Position") },
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                singleLine = true
            )
            OutlinedTextField(
                value = point4Y,
                onValueChange = { point4Y = it },
                label = { Text("Y Position") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }
    }
}
