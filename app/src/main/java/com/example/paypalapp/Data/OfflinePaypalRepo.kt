package com.example.paypalapp.Data

import retrofit2.Call
import javax.inject.Inject


class OfflinePaypalRepo @Inject constructor(private val apiService: ApiService) :  PaypalRepo {
    override suspend fun registerUser(user: User): Call<UserDetails> {
        return apiService.signUp(user)
    }

    override suspend fun loginUser(userDetails: UserDetails): Call<UserToken> {
        return apiService.login(userDetails)
    }
}