package com.example.paypalapp

import com.example.paypalapp.Data.OfflinePaypalRepo
import com.example.paypalapp.Data.PaypalRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PaypalRepoModule {

    @Binds
    abstract fun provideRepo(offlinePaypalRepo: OfflinePaypalRepo): PaypalRepo
}