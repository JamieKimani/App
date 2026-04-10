package com.example.carparkingsystem.ui.theme.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.carparkingsystem.data.AuthViewModel
import com.example.carparkingsystem.navigation.ROUTE_LOGIN

val Blue = Color(0xFF1A73E8)
val PageBg = Color(0xFFF0F2F5)
val InputBorder = Color(0xFFE0E0E0)
val TextHint = Color(0xFF888888)
val TextPrimary = Color(0xFF1A1A1A)
val TextLabel = Color(0xFF444444)

@Composable
fun RegisterScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PageBg),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .verticalScroll(rememberScrollState()),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Logo circle
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Blue, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "P",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Create Account",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )

                Text(
                    text = "Car Parking System",
                    fontSize = 13.sp,
                    color = TextHint,
                    modifier = Modifier.padding(top = 2.dp, bottom = 24.dp)
                )

                // Username
                RegisterField(
                    label = "Username",
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "Enter your username",
                    icon = Icons.Default.Person
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Email
                RegisterField(
                    label = "Email",
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "Enter your email",
                    icon = Icons.Default.Email
                )

                Spacer(modifier = Modifier.height(12.dp))

                RegisterField(
                    label = "Password",
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Enter your password",
                    icon = Icons.Default.Lock,
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(12.dp))


                RegisterField(
                    label = "Confirm Password",
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = "Re-enter your password",
                    icon = Icons.Default.Check,
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        authViewModel.signup(
                            username = username,
                            email = email,
                            password = password,
                            confirmpassword = confirmPassword,
                            navController = navController,
                            context = context
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Blue)
                ) {
                    Text(
                        text = "Register",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))


                Row(horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Already registered? ",
                        fontSize = 13.sp,
                        color = TextHint
                    )
                    Text(
                        text = "Login here",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = Blue,
                        modifier = Modifier.clickable { navController.navigate(ROUTE_LOGIN) }
                    )
                }
            }
        }
    }
}

@Composable
fun RegisterField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    icon: ImageVector,
    isPassword: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = TextLabel,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = Color(0xFFBBBBBB)) },
            leadingIcon = { Icon(icon, contentDescription = null) },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Blue,
                unfocusedBorderColor = InputBorder,
                focusedLeadingIconColor = Blue,
                unfocusedLeadingIconColor = Color(0xFFAAAAAA),
                cursorColor = Blue
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())
}