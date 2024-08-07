package com.example.paypalapp.Data

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.paypalapp.R

data class IconDataClass(
    val text : String,
    val icon : Int){

    companion object{
        fun getIcons(): List<IconDataClass>{
            return listOf(
                IconDataClass("Transfer", R.drawable.trasnfer),
                IconDataClass("My Wallet", R.drawable.wallet),
                IconDataClass("Bank",R.drawable.bank),
                IconDataClass("Analytics",R.drawable.analytics),
                IconDataClass("Transfer", R.drawable.trasnfer),
                IconDataClass("My Wallet", R.drawable.wallet),
            )
        }
    }
}




