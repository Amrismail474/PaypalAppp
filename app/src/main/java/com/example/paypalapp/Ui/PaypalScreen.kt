package com.example.paypalapp.Ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.paypalapp.Data.PaypalViewModel


enum class Paypalpages(var title:String){
    Logo("LogoPage"),
    Registration("registration"),
    Home("home"),

}


@Composable
fun PaypalAppScreen(
    navController: NavHostController = rememberNavController(),
    contentPadding:PaddingValues,
    viewModel: PaypalViewModel
){


    var email = viewModel.email.collectAsState()
    var name = viewModel.name.collectAsState()
    var password = viewModel.name.collectAsState()
    
    NavHost(navController, Paypalpages.Logo.title){
        composable(Paypalpages.Logo.title){
            SplashScreen(modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding), navigateTo={ page->
                navController.navigate(page)
            })
        }
        composable(Paypalpages.Registration.title){
            RegistrationPage(modifier  = Modifier
                .fillMaxSize()
                .padding(contentPadding),
                email = email.toString(),
                onEmailChange = {},
                name = name.toString(),
                onNameChange = {},
                password = password.toString(),
                onPasswordChange = {},

                onclick = { email, name, password ->
                    viewModel.offlineRegistration(name,password,email)
                },
                onLoginClick = {})
        }
        composable(Paypalpages.Home.title){
            PaypalAppUI()
        }
    }
}