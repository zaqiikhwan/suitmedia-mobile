package com.msib.suitmedia.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.msib.suitmedia.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_1),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }

    var name by remember { mutableStateOf("") }
    var sentence by remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = name,
            modifier = Modifier
                .padding(32.dp, 320.dp, 33.dp, 15.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
            ,
            onValueChange = { name = it },
            label = { Text("Name", color = Color.Black) }
        )

        OutlinedTextField(
            value = sentence,
            modifier = Modifier
                .padding(32.dp, 0.dp, 33.dp, 15.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color.White)
            ,
            onValueChange = { sentence = it },
            label = { Text("Sentence", color = Color.Black) }
        )
        fun onConfirmClicked() {
            openDialog.value = false
        }

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {},
                title = {
                    Text(text = "Result")
                },
                text = {
                    val isPalindrome = isPalindromeCheck(sentence)
                    val message = if(isPalindrome) "isPalindrome" else "not palindrome"
                    Text(message)
                },
                confirmButton = {
                    Button(onClick = {
                        onConfirmClicked()
                    }) {
                        Text("OK")
                    }
                }
            )
        }
        Button(
            onClick = {
                openDialog.value = true
            },
            modifier = Modifier
                .padding(32.dp, 15.dp)
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .background(color = Color(0xFF2B637B)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2B637B),
                contentColor = Color.White)
        ) {
            Text("CHECK")
        }

        Button(
            onClick = { /* navigate to second screen */ },
            modifier = Modifier
                .padding(32.dp, 0.dp)
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .background(color = Color(0xFF2B637B)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2B637B),
                contentColor = Color.White)
        ) {
            Text(
                "NEXT",
                textAlign = TextAlign.Center
            )
        }

    }


}

fun isPalindromeCheck(input: String): Boolean {
    val cleanInput = input.replace("\\s".toRegex(), "").lowercase()
    return cleanInput == cleanInput.reversed()
}


