package com.mcvector36.reportloto

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.content.Context
import android.widget.ImageView




import android.os.Handler

import androidx.compose.runtime.mutableStateOf

import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebViewWithLoader(context = this)
        }
    }
}

@Composable
fun WebViewWithLoader(context: Context) {
    val loadingImageResourceId = R.drawable.animatie // ID-ul resursei pentru animația de încărcare
    val webViewLoaded = remember { mutableStateOf(false) }

    // Handler pentru a întârzia încărcarea paginii după afișarea animației
    val handler = Handler()

    // Simulăm încărcarea paginii
    val timer = Timer()
    timer.schedule(object : TimerTask() {
        override fun run() {
            webViewLoaded.value = true // Marchează că pagina web s-a încărcat
        }
    }, 5000) // După 5 secunde, simulăm încărcarea completă a paginii

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        // Afișăm WebView-ul sau imaginea de încărcare în funcție de starea încărcării paginii
        if (webViewLoaded.value) {
            AndroidView(
                factory = { ctx ->
                    WebView(ctx).apply {
                        layoutParams = android.view.ViewGroup.LayoutParams(
                            android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                            android.view.ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        settings.javaScriptEnabled = true
                        webViewClient = WebViewClient()
                        loadUrl("https://www.loto.ro/?p=3872") // Înlocuiți cu URL-ul paginii web dorite
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        } else {
            AndroidView(
                factory = { ctx ->
                    WebView(ctx).apply {
                        layoutParams = android.view.ViewGroup.LayoutParams(
                            android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                            android.view.ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        settings.javaScriptEnabled = true
                        loadUrl("file:///android_res/drawable/animatie.gif") // Încărcăm animația de încărcare
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
