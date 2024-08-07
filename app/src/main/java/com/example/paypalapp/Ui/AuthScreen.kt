package com.example.paypalapp.Ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paypalapp.R
import com.example.paypalapp.ui.theme.PaypalAppTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(modifier: Modifier,
                 navigateTo:(String)->Unit){
    LaunchedEffect(Unit) {
        delay(3000) // Wait for 3 seconds
        navigateTo(Paypalpages.Registration.title)
    }

    Box( modifier = modifier
        .fillMaxWidth()
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.onSecondaryContainer), contentAlignment = Alignment.Center){
        Column(modifier.padding(26.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.paypallogo),
                contentDescription = "Paypal HomePage")
        }
    }
}


@Composable
fun RegistrationPage(modifier: Modifier,
                     email: String,
                     onEmailChange: (String) -> Unit,
                     name:String,
                     onNameChange: (String) -> Unit,
                     password:String,
                     onPasswordChange: (String) -> Unit,
                     onclick: (String,String,String)->Unit,
                     onLoginClick:()->Unit
) {
    Box(
        modifier = modifier
            .padding(top = 80.dp)
            .padding(16.dp)
            .height(500.dp)
            .fillMaxSize()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier.padding(24.dp)) {
                Text(text = "Register Here", fontSize = 30.sp, color = Color.White)
            }

            Row {
                OutlinedTextField(
                    value = email,
                    onValueChange = onEmailChange,
                    placeholder = { Text("Email Address")},textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row {
                OutlinedTextField(
                    value = name,
                    onValueChange = onNameChange,
                    placeholder = { Text("Name") },textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                OutlinedTextField(
                    value = password,
                    onValueChange = onPasswordChange,
                    placeholder = { Text("Password") },textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {

            }
            Row {
                Button(onClick = { onclick(email,name,password) }, modifier=Modifier.width(200.dp)) {
                    Text(text = "Sign Up")

                }}
            Spacer(modifier = Modifier.height(8.dp))

            Column {
                Box(modifier.padding(6.dp)) {
                    Row {

                        val annotatedString = buildAnnotatedString {
                            append("If You Already Have An Account  ")
                            withStyle(style = SpanStyle( color = Color.Blue, textDecoration = TextDecoration.Underline)){
                                append("Login Here.")
                            }
                        }
                        ClickableText(
                            text = annotatedString,
                            style = TextStyle(Color.White),
                            onClick = {offset->
                                if(offset in annotatedString.length -10 until annotatedString.length)
                                    onLoginClick() }
                        )
                    }
                }
            }



        }
    }
}

@Composable
fun LoginPage(modifier: Modifier,
              email: String,
              onEmailChange: (String) -> Unit,
              password: String,
              onPasswordChange: (String) -> Unit,
              onLoginClick:(String,String)->Unit
) {
    Box(
        modifier = modifier
            .padding(top = 80.dp)
            .padding(16.dp)
            .height(500.dp)
            .fillMaxSize()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier.padding(24.dp)) {
                Text(text = "Register Here", fontSize = 30.sp, color = Color.White)
            }

            Row {
                OutlinedTextField(
                    value = email,
                    onValueChange = onEmailChange,
                    placeholder = { Text("Email Address")},textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                OutlinedTextField(
                    value = password,
                    onValueChange = onPasswordChange,
                    placeholder = { Text("Password") },textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {

            }
            Row {
                Button(onClick = { onLoginClick(email,password) }, modifier=Modifier.width(200.dp)) {
                    Text(text = "Login")

                }}
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}





@Preview
@Composable
fun PreviewRegistrationPage() {
    PaypalAppTheme {
        //FirstPage(modifier = Modifier,take={})
        RegistrationPage(
            modifier = Modifier,
            email = "Aisha@example.com",
            onEmailChange = {},
            name = "Aisha Odenike",
            onNameChange = {},
            password = "password123",
            onPasswordChange = {},
            onLoginClick = {},
            onclick = { _, _, _ -> }
        )
    }
}
