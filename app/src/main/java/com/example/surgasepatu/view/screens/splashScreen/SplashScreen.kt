package com.example.surgasepatu.view.screens.splashScreen

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surgasepatu.MainActivity
import com.example.surgasepatu.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        delay(3000)
        context.startActivity(Intent(context, MainActivity::class.java))
        (context as? Activity)?.finish()
    }
    
    Splash()
}

@Composable
fun Splash(
    modifier: Modifier = Modifier
) {
   Box(
       modifier
           .fillMaxSize()
           .background(
               brush = Brush.linearGradient(
                   colors = listOf(
                       colorResource(id = R.color.ocean_boat_blue),
                       colorResource(id = R.color.rich_black)
                   )
               )
           )
   ) {
       Column(
           modifier
               .fillMaxWidth()
               .padding(top = 210.dp),
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Image(
               painter = painterResource(id = R.drawable.logo_white_text),
               contentDescription = "logo",
               modifier.size(200.dp)
           )

           Spacer(modifier = Modifier.height(40.dp))
           Text(
               text = "Find Your Dream\n" + "Shoes With Us!",
               fontSize = 16.sp,
               fontWeight = FontWeight.Medium,
               color = Color.White,
               textAlign = TextAlign.Center,
               lineHeight = 22.sp
           )
       }
   }
}

@Preview
@Composable
private fun view() {
    Splash()
}