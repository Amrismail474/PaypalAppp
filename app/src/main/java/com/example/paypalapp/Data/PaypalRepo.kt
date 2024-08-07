package com.example.paypalapp.Data

import retrofit2.Call

interface PaypalRepo {
    suspend fun registerUser(user: User): Call<UserDetails>
    suspend fun loginUser(userDetails: UserDetails) : Call<UserToken>
}