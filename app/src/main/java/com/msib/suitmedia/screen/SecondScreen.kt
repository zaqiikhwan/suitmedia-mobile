package com.msib.suitmedia.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Second Screen", textAlign = TextAlign.Center, modifier = Modifier.width(260.dp), style = MaterialTheme.typography.bodyMedium, fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back", tint = Color.Blue)
                    }
                }
            )
        }
    ) {
        Column {
            Text(text = "Welcome", Modifier.padding(21.dp, 60.dp, 21.dp, 0.dp), style = MaterialTheme.typography.bodySmall, fontSize = 12.sp)
            Text(text = "John Doe", Modifier.padding(20.dp, 0.dp), style = MaterialTheme.typography.bodyMedium, fontSize = 18.sp)
            Text(text = "Selected User Name",
                Modifier
                    .padding(21.dp, 222.dp, 21.dp, 0.dp)
                    .fillMaxWidth(), style = MaterialTheme.typography.bodyMedium, fontSize = 24.sp, textAlign = TextAlign.Center)
            Button(
                onClick = { navController.navigate("third") {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) { saveState = true }
                    }
                    launchSingleTop = true
                    restoreState = true
                } },
                modifier = Modifier
                    .padding(32.dp, 265.dp, 32.dp, 32.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .background(color = Color(0xFF2B637B)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2B637B),
                    contentColor = Color.White)
            ) {
                Text(
                    "Choose a User",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium, fontSize = 14.sp, fontWeight = FontWeight.Normal
                )
            }
        }
    }
}