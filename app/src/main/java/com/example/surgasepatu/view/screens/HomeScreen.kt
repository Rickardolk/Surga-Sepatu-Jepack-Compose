package com.example.surgasepatu.view.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surgasepatu.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
   Box(
       modifier
           .fillMaxSize()
           .background(Color.White)
   ) {
       Column(
           modifier
               .fillMaxWidth()
               .padding(top = 48.dp)
               .padding(horizontal = 24.dp)
       ) {
           Row(
               modifier
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
           ) {
               Column {
                   Text(
                       text = "Hi, User👋🏻",
                       fontSize = 26.sp,
                       fontWeight = FontWeight.SemiBold,
                       color = colorResource(id = R.color.rich_black)
                   )

                   Spacer(modifier = Modifier.height(8.dp))
                   Text(
                       text = "Elevate your style with every step!",
                       fontSize = 14.sp,
                       color = colorResource(id = R.color.old_silver)
                   )
               }

               Column(
                   modifier
                       .size(50.dp)
                       .clip(shape = CircleShape)
                       .border(
                           shape = CircleShape,
                           width = 2.dp,
                           color = colorResource(id = R.color.ocean_boat_blue)
                       )
               ) {
                   Image(
                       painter = painterResource(id = R.drawable.person),
                       contentDescription = "person",
                   )
               }
           }



       }
   }
}

@Preview
@Composable
private fun view() {
    HomeScreen()
}