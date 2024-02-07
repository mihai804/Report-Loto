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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
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
                    Start6din49()
//                    StartJoker()

                }
            }
        }

    }
}

@Composable
fun Start6din49() {
    val buton6din49 = LocalContext.current

    val buton1 = Button(onClick = {
            val intent6din49 = Intent(buton6din49, Report6din49::class.java)
            buton6din49.startActivity(intent6din49)
        }) {
            Text(text = "6 din 49",
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp)
        }
}

@Composable
fun StartJoker() {
    val butonjoker = LocalContext.current

    val buton2 = Button( onClick = {
        val intentjoker = Intent(butonjoker, ReportJoker::class.java)
        butonjoker.startActivity(intentjoker)
    }) {

        Text(
            text = "Joker",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        )
    }
}