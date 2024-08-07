package com.example.paypalapp.Data

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PaypalViewModel @Inject constructor(private val offlinePaypalRepo: OfflinePaypalRepo,
                                          private val prefrence: PaypalSharedPrefrence,
                                            private val saveStateHandle: SavedStateHandle) : ViewModel(){

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email
    private val savedEmail = saveStateHandle.getStateFlow("email", "")


    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name


    init {

        _email.value = savedEmail.value
    }


   fun register(user: User, onSuccess : (String, String)->Unit, onFailure: (Throwable) -> Unit){
        viewModelScope.launch {
            offlinePaypalRepo.registerUser(user).enqueue(object : Callback<UserDetails>{
                override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                    if(response.isSuccessful){
                        response.body()?.let { userdetails->
                            onSuccess(userdetails.name, userdetails.password) }
                    }
                }

                override fun onFailure(call: Call<UserDetails>, t: Throwable) {
                    onFailure(t)
                }

            })
        }
    }

    fun login(userDetails: UserDetails, onSuccess: (UserToken) -> Unit, onFailure: (Throwable) -> Unit){

        viewModelScope.launch {
            offlinePaypalRepo.loginUser(userDetails).enqueue(object : Callback<UserToken>{
                override fun onResponse(call: Call<UserToken>, response: Response<UserToken>) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            onSuccess(it)
                        }
                    }
                }

                override fun onFailure(call: Call<UserToken>, t: Throwable) {
                   onFailure(t)
                }

            })
        }

    }


    fun offlineRegistration(name:String, password:String,email:String){
        prefrence.saveLocally(name, password,email)
    }

    fun updateEmail(email:String){
        _email.value = email
        saveStateHandle["email"] = email
    }
    fun updatePassword(password: String){
        _password.value = password
    }
    fun updateName(name: String){
        _name.value = name
    }


}