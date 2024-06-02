package com.example.loginjetpackcompose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginjetpackcompose.ui.theme.ButtonBlue
import com.example.loginjetpackcompose.ui.theme.EditTextBg
import com.example.loginjetpackcompose.ui.theme.Magenta40
import com.example.loginjetpackcompose.ui.theme.Midnightlue40
import com.example.loginjetpackcompose.ui.theme.TextBlue
import com.example.loginjetpackcompose.ui.theme.TextGrey


@Composable
fun RegisterScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val userRepository = remember { UserRepository(context) }
    val viewModel: RegisterViewModel = viewModel(
        factory = RegisterViewModelFactory(userRepository)
    )
    val registrationStatus by viewModel.registrationStatus.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        LinearGradientBackground()
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(28.dp,16.dp,28.dp,16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Booking image",
                    modifier = Modifier.size(42.dp)
                )
                Text(
                    "LOGO",
                    color = Color.White,
                    fontSize = 40.sp,
                )
            }

            /*var userName by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var phoneNumber by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }*/

            var userName by rememberSaveable { mutableStateOf("") }
            var email by rememberSaveable { mutableStateOf("") }
            var phoneNumber by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            CustomTextField(
                value = userName,
                onValueChange = { userName = it },
                placeholder = "Enter User Name",
                leadingIconResId = R.drawable.ic_user
            )

            CustomTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Enter email",
                leadingIconResId = R.drawable.ic_email
            )

            CustomTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                placeholder = "Enter PhoneNumber",
                leadingIconResId = R.drawable.ic_phone
            )

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter password",
                visualTransformation = PasswordVisualTransformation(),
                leadingIconResId = R.drawable.ic_password
            )

            Text(
                "Forgot password?",
                color = TextBlue,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { /* Handle forgot password */ }
                    .padding(bottom = 42.dp)
            )

            Button(
                onClick = {
                    viewModel.register(User(
                        userName = userName,
                        email = email,
                        phoneNumber = phoneNumber,
                        password = password
                    ))
                },
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),

                colors = ButtonDefaults.buttonColors(ButtonBlue),
                shape = RectangleShape
            ) {
                Text("SIGN UP", color = Color.White)
            }


            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val text = buildAnnotatedString {
                    append("Already have an account?")
                }

                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = TextGrey,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "LOGIN",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = TextBlue,
                    modifier = Modifier.clickable {
                        navController.navigate("loginDestination")
                    }
                )
            }
        }
        SocialMediaButton(
            modifier = modifier.align(Alignment.BottomCenter)
        )

    }

    // Show toast message when registration is successful
    LaunchedEffect(registrationStatus) {
        if (registrationStatus) {
            Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
            navController.navigate("loginDestination") // Navigate to login screen after registration
            viewModel.resetRegistrationStatus() // Reset registration status if needed
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun RegisterScreenPreview() {
//    RegisterScreen(rememberNavController())
    RegisterScreen(navController = rememberNavController())
}