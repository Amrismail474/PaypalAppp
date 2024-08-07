package com.example.paypalapp.Ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.paypalapp.Data.IconDataClass
import com.example.paypalapp.R
import com.example.paypalapp.ui.theme.PaypalAppTheme

@Composable
fun PaypalAppUI() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier

            .fillMaxSize()
            .fillMaxWidth()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp, top = 20.dp)
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(16.dp))
            BalanceSection()
            Spacer(modifier = Modifier.height(16.dp))
            Grid()
            Spacer(modifier = Modifier.height(16.dp))
            QuickTransactionsSection()
            Spacer(modifier = Modifier.height(16.dp))
            ActivitySection()
        }
    }

}

@Composable
fun HeaderSection() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(Modifier.weight(1F)){
                Image(painter = painterResource(id = R.drawable.person),
                    contentDescription = "ProfilePicture",
                    Modifier
                        .padding(8.dp)
                        .size(100.dp)
                        .weight(0.2F)
                        .background(Color.White, shape = RectangleShape)
                )

                Column(modifier = Modifier
                    .padding(top = 30.dp)
                    .weight(0.5F)) {
                    Text(
                        text = "Good Morning,",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Lexi",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }}
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color.White
                )
            }
        }
    }

}

@Composable
fun BalanceSection() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total Balance",
                fontSize = 28.sp,
                color = Color.White
            )
            Text(
                text = "$12,544.00",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
                    .background(Color.Black), contentAlignment = Alignment.Center // Set your general background color here
            ){
                Row(
                    modifier = Modifier.padding(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(8.dp)

                        ,shape = RoundedCornerShape(16.dp)
                    ) {
                        Text("Send")
                    }
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
                        Text("Receive")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More",
                            tint = Color.White)
                    }
                }
            }

        }
    }


}
@Composable
fun MiddleSection(modifier:Modifier, onclick : ()-> Unit, iconDataClass: IconDataClass){

    Card(modifier = modifier
        .padding(8.dp)
        .fillMaxWidth()
        .height(80.dp)
        .clickable { onclick() }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
            ) {
            Box(
                modifier = Modifier  // Align with card margins
                    .padding(4.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Text(
                    text = iconDataClass.text,
                    modifier = Modifier.padding(8.dp),
                    color = Color.White,
                )
            }
            Icon(painter = painterResource( iconDataClass.icon), contentDescription = iconDataClass.text)
        }
    }
}

@Composable
fun Grid(){
    var icons = IconDataClass.getIcons()
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(icons){ icon->
            MiddleSection(modifier = Modifier, onclick = { /*TODO*/ }, iconDataClass = icon)

        }
        
    }
}

@Composable
fun QuickTransactionsSection() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .background(Color.Black)){

        Column {
            Text(
                text = "Quick Transactions",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(9.dp)

            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp)
            ) {
                // Replace with real avatars
                listOf("John", "Mateo","Ammaar","Ismail").forEach {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = it,
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    shape = RoundedCornerShape(16.dp)
                                )
                        )
                        Text(
                            text = it,
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun ActivitySection() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()){

        Column {
            Text(
                text = "Activity",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "$312",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Daily Average",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
                Column {
                    Text(
                        text = "10%",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "More than Last week",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }

}

@Composable
fun topBar(){

    Row(modifier = Modifier.padding(24.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Good Morning Lexi")

        Spacer(modifier = Modifier.weight(1F))

        Image(painter = painterResource(id = R.drawable.bank), contentDescription ="bank",
            modifier = Modifier.size(24.dp) )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPaypalAppUI() {
    PaypalAppTheme {
        //PaypalAppUI()
        topBar()
       // Grid()
        //MiddleSection(modifier = Modifier, onclick = { /*TODO*/ }, iconDataClass = IconDataClass("Transfer", R.drawable.trasnfer))
    }
}
