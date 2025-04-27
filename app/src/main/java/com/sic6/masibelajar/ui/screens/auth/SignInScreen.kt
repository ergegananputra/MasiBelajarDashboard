package com.sic6.masibelajar.ui.screens.auth

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sic6.masibelajar.R
import com.sic6.masibelajar.ui.navigation.graphs.AuthGraph
import com.sic6.masibelajar.ui.navigation.graphs.FeatureGraph
import com.sic6.masibelajar.ui.navigation.graphs.RootGraph
import com.sic6.masibelajar.ui.screens.components.CircleBackground
import com.sic6.masibelajar.ui.theme.MasiBelajarDashboardTheme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun SignInScreenDeveloperPreview() {
    MasiBelajarDashboardTheme {
        val navController = rememberNavController()
        SignInScreen(navController)
    }
}

fun loginUser(username: String, password: String, callback: (Result<Unit>) -> Unit) {
    if (password.length > 8) {
        callback(Result.success(Unit))
    } else {
        callback(Result.failure(Exception("Password must be longer than 8 characters")))

    }
}


@Composable
fun SignInScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(60.dp))
            // Box untuk mengatur posisi gambar bayi
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Pusatkan horizontal
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_lokari_2),
                    contentDescription = "Illustration",
                    modifier = Modifier
                        .size(200.dp) // Perbesar gambar bayi
                        .align(Alignment.Center)
//                        .offset(y = (-100).dp) // Geser ke bawah agar proporsional
                )
            }

            // Welcome text
            Text(
                text = "Welcome Back!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Form Sign In
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Sign In",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
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
                        Text(
                            text = "Forgot Password?",
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Login Button
//                Button(
//                    onClick = {
//                        navController.navigate(FeatureGraph.Dashboard) {
//                            popUpTo(RootGraph.Auth) {
//                                inclusive = true
//                            }
//                        }
//                    },
//                    modifier = Modifier.fillMaxWidth(),
//                    shape = RoundedCornerShape(8.dp)
//                ) {
//                    Text("Log In")
//                }

                val context = LocalContext.current
                Button(
                    onClick = {
                        loginUser(email, password) { result ->
                            result.onSuccess {
                                navController.navigate(FeatureGraph.Dashboard) {
                                    popUpTo(RootGraph.Auth) {
                                        inclusive = true
                                    }
                                }
                            }.onFailure { exception ->
                                // Misal: munculin Toast atau Snackbar error
                                println("Login failed: ${exception.message}")
                                Toast.makeText(context, exception.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ){
                    Text("Log In")
                }

                // Sign Up
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Don’t have an account?")
                    TextButton(onClick = { navController.navigate(AuthGraph.SignUp) }) {
                        Text("Sign Up")
                    }
                }
            }
        }

        // Gambar lingkaran bawah
        CircleBackground(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 328.dp)
                .zIndex(-1f)
        )
    }
}

