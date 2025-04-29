package com.sic6.masibelajar.ui.screens.smart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Face4
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sic6.masibelajar.R

@Composable
fun AlarmScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var waitTime by remember { mutableStateOf("3000") }
    var fallDetection by remember { mutableStateOf(false) }
    var safezoneDetection by remember { mutableStateOf(true) }
    var targetClass by remember { mutableStateOf("Toddler") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top bar
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Alarm Config",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = { /* Save action */ },
                colors = ButtonDefaults.buttonColors()
            ) {
                Text("Save")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Notification Wait Time (seconds)", fontWeight = FontWeight.Medium)
        OutlinedTextField(
            value = waitTime,
            onValueChange = { waitTime = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Alarm Active", fontWeight = FontWeight.Medium)
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

        Text("Target Class", fontWeight = FontWeight.Medium)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { targetClass = "Toddler" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (targetClass == "Toddler") Color.Gray else Color.LightGray
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.ChildCare, contentDescription = "Toddler")
                Spacer(modifier = Modifier.width(2.dp))
                Text("Toddler")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { targetClass = "Non-Toddler" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (targetClass == "Non-Toddler") Color.Gray else Color.LightGray
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.Face4, contentDescription = "Toddler")
                Spacer(modifier = Modifier.width(2.dp))
                Text("Non Toddler")
            }
        }


        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Share Notification", fontWeight = FontWeight.Medium)
        Row {
            // Placeholder images. Replace with actual image loading in production.
            listOf("Adiel", "Marwah").forEach { name ->
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(end = 8.dp)) {
                    Image(
                        painter = painterResource(id = R.mipmap.ic_lokari_2), // Replace with actual image
                        contentDescription = name,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )
                    Text(name, fontSize = 12.sp)
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .clickable { /* Add person */ }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    }

