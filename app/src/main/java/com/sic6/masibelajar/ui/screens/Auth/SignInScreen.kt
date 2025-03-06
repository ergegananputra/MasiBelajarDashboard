package com.sic6.masibelajar.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.sic6.masibelajar.R

@Composable
fun SignInScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
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

            // Welcome text
            Text(
                text = "Welcome Back!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E5A87)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Form Sign In
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Sign In",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(12.dp))

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
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password Icon") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
                    Text(text = "Remember me", fontSize = 14.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = { /* Forgot password logic */ }) {
                        Text("Forgot Password?", color = Color(0xFF1E5A87))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Login Button
                Button(
                    onClick = { /* Login logic */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E5A87)),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Log In", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Sign Up
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Don’t have an account?")
                    TextButton(onClick = { navController.navigate("sign_up") }) {
                        Text("Sign Up", color = Color(0xFF1E5A87))
                    }
                }
            }
        }

        // Gambar lingkaran bawah
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

