package com.example.paypalapp.Data
import android.content.Context
import javax.inject.Inject


class PaypalSharedPrefrence @Inject constructor(context : Context) {

    private var sharedPrefrences = context.getSharedPreferences("storage", Context.MODE_PRIVATE)


    fun saveLocally(name:String, password:String,email:String){
        sharedPrefrences.edit()
            .putString("name", name)
            .putString("password", password)
            .putString("email",email)
            .apply()
    }

    fun getName(): String? {
        return sharedPrefrences.getString("name", null)
    }

    fun getPassword(): String? {
        return sharedPrefrences.getString("password", null)
    }

}