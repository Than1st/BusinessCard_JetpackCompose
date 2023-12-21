package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BioInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.sulthan), contentDescription = null)
        Text(text = "Sulthan Laksono Ramadhan", fontSize = 26.sp, modifier = Modifier.padding(8.dp))
        Text(text = "Android Developer Extraordinaire", color = colorResource(id = R.color.green))
    }
}

@Composable
fun ContactInfoItem(logo: ImageVector, info: String) {
    Row {
        Image(
            imageVector = logo,
            contentDescription = null,
            colorFilter = ColorFilter.tint(colorResource(id = R.color.green)),
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp)

        )
        Text(
            text = info,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun BusinessCard() {
    Box(
        Modifier.background(colorResource(id = R.color.light_green))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            BioInfo()
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Column{
                ContactInfoItem(Icons.Filled.Call, "+62 95-3266-53527")
                ContactInfoItem(Icons.Filled.Share, "@thanfpv")
                ContactInfoItem(Icons.Filled.Email, "thanfpv@gmail.com")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}