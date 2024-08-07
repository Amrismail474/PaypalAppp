package com.example.paypalapp.Data

data class User(

    val name: String,
    val email : String,
    val bvn : Int,
    val number : Int
)

data class UserToken(
    val token: String
)

data class UserDetails(
    val name: String,
    val password : String,
)


