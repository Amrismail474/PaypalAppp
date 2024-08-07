package com.example.paypalapp.Data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/login")
    fun login(@Body userDetails: UserDetails): Call<UserToken>

    @POST("/auth/signUp")
    fun signUp(@Body user: User) : Call<UserDetails>

}