package com.example.gestiondetaches.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Gradient background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4CAF50), // Green
                        Color(0xFF2196F3)  // Blue
                    )
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            // "Login" title
            Text(
                text = "Login",
                fontSize = 32.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Email field
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Email", color = Color.White) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.White,
                    containerColor = Color.Transparent

                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon",
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.White,
                    containerColor = Color.Transparent

                )
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Login button
            Button(
                onClick = { navController.navigate("calendar") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text("Submit")
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Remember me and Forgot password
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(Color.White)
                )
                Text(text = "Remember", color = Color.White)
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /* Forgot action */ }) {
                    Text("Forgot", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Join Us button
            OutlinedButton(
                onClick = { /* Sign-up action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text("Join Us !")
            }
        }
    }
}
