package com.mcvector36.reportloto


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.mcvector36.reportloto.ui.theme.ReportLotoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReportLotoTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
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