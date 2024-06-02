package com.example.loginjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.loginjetpackcompose.ui.theme.EditTextBg


@Composable
fun SocialMediaButton(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp).background(EditTextBg),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        /*Text("Facebook", color = Color.White, modifier = Modifier.clickable { *//* Handle Facebook login *//* })
        Text("Google", color = Color.White, modifier = Modifier.clickable { *//* Handle Google login *//* })*/

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo_facebook),
                contentDescription = "Booking image",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Facebook", color = Color.White, modifier = Modifier.clickable { })
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo_google),
                contentDescription = "Booking image",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Google", color = Color.White, modifier = Modifier.clickable { })
        }

    }
}
