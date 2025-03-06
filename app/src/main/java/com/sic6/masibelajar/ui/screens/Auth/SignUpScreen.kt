package com.sic6.masibelajar.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sic6.masibelajar.R
import kotlin.math.max

@Composable
fun SignUpScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Box untuk mengatur posisi gambar bayi
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Pusatkan horizontal
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baby_cloud),
                    contentDescription = "Illustration",
                    modifier = Modifier
                        .size(300.dp) // Perbesar gambar bayi
                        .align(Alignment.Center)
//                        .offset(y = (-100).dp) // Geser ke bawah agar proporsional
                )
            }
            Text(
                text = "Nice To Meet You!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E5A87)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Form Sign Up
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Sign Up",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Input Username
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Username Icon"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Input Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email address") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Input Password
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = "Password Icon"
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Sign Up Button
                Button(
                    onClick = { /* Sign Up Logic */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E5A87)),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Sign Up", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Navigate to Sign In
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Already have an account?")
                    TextButton(onClick = { navController.popBackStack() }) {
                        Text("Sign In", color = Color(0xFF1E5A87))
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_circle_layer),
                contentDescription = "circle",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
                    .scale(1.5f)
                    .offset(y = 400.dp)
            )
        }
    }
}
