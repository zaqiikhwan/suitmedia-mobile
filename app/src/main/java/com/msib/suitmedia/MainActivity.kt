package com.msib.suitmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msib.suitmedia.screen.FirstScreen
import com.msib.suitmedia.screen.SecondScreen
import com.msib.suitmedia.screen.ThirdScreen
import com.msib.suitmedia.ui.theme.SuitmediainternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuitmediainternTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "first") {
                        composable(route = "first") {
                            FirstScreen(navController)
                        }
                        composable(route = "second") {
                            SecondScreen(navController)
                        }
                        composable(route = "third") {
                            ThirdScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
