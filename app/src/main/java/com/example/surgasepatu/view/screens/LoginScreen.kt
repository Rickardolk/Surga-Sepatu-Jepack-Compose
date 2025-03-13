package com.example.surgasepatu.view.screens

import android.content.Context
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.surgasepatu.R
import com.example.surgasepatu.viewModel.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = viewModel(),
    navController: NavController,
    context: Context
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_black_text),
                contentDescription = "logo",
                modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Login",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.rich_black)
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = { Text(text = "Email")},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "ic email"
                    )
                },
                maxLines = 1,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.ocean_boat_blue),
                    focusedLabelColor = colorResource(id = R.color.ocean_boat_blue),
                    unfocusedLabelColor = colorResource(id = R.color.old_silver),
                    focusedLeadingIconColor = colorResource(id = R.color.ocean_boat_blue),
                    unfocusedLeadingIconColor = colorResource(id = R.color.old_silver),
                    cursorColor = colorResource(id = R.color.ocean_boat_blue)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = { Text(text = "Password")},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "ic password"
                    )
                },
                maxLines = 1,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(id = R.color.ocean_boat_blue),
                    focusedLabelColor = colorResource(id = R.color.ocean_boat_blue),
                    unfocusedLabelColor = colorResource(id = R.color.old_silver),
                    focusedLeadingIconColor = colorResource(id = R.color.ocean_boat_blue),
                    unfocusedLeadingIconColor = colorResource(id = R.color.old_silver),
                    cursorColor = colorResource(id = R.color.ocean_boat_blue)
                )
            )

            Column(
                modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                TextButton(
                    onClick = {
                        navController.navigate("reset password")
                    }
                ) {
                    Text(
                        text = "Forgot password?",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.ocean_boat_blue)
                    )
                }
            }

            Button(
                onClick = {
                    loginViewModel.login(email, password, context, navController)
                },
                 modifier = Modifier
                     .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.ocean_boat_blue)
                )
            ) {
               Text(
                   text = "Login",
                   fontSize = 20.sp,
                   fontWeight = FontWeight.SemiBold,
                   color = Color.White
               )
            }

            Row(
                modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = {
                        navController.navigate("register")
                    }
                ) {
                   Text(
                       text = "Register",
                       fontSize = 12.sp,
                       color = colorResource(id = R.color.ocean_boat_blue)
                   )
                }

                Text(
                    text = "if you don't have an account",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.onyx_black)
                )
            }
        }
    }
}

