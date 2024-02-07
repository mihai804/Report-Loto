package com.mcvector36.reportloto


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }

    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Button(onClick = {
            val intent = Intent(context, Report6din49::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "6 din 49")
        }
}