package com.example.paypalapp

import android.app.Application
import android.content.Context
import com.example.paypalapp.Data.OfflinePaypalRepo
import com.example.paypalapp.Data.PaypalRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object paypalRetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    @Provides
    fun provideContext(application: Application): Context = application.applicationContext


}