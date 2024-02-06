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
import androidx.core.content.res.ResourcesCompat


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
    val webView = remember { WebView(context) }
    val loadingImageResourceId = R.drawable.animatie // Id-ul resursei pentru imaginea de încărcare

    val webViewClient = object : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
            super.onPageStarted(view, url, favicon)
            // Când începe încărcarea paginii, afișăm imaginea de încărcare
            webView.visibility = android.view.View.INVISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            // După ce pagina s-a încărcat complet, facem WebView vizibilă și eliminăm imaginea de încărcare
            webView.visibility = android.view.View.VISIBLE
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { webView },
            update = { view ->
                with(view.settings) {
                    javaScriptEnabled = true
                    cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                }
                view.webViewClient = webViewClient
                view.loadUrl("https://www.loto.ro/?p=3872") // Înlocuiți cu URL-ul paginii web dorite
            }
        )

        // Imaginea de încărcare
        AndroidView(
            factory = { context ->
                ImageView(context).apply {
                    setImageDrawable(ResourcesCompat.getDrawable(context.resources, loadingImageResourceId, null))
                    layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                }
            },
            modifier = Modifier.align(Alignment.Center),
            update = { imageView ->
                // Afișăm sau ascundem imaginea în funcție de vizibilitatea WebView-ului
                imageView.visibility = if (webView.visibility == android.view.View.VISIBLE) android.view.View.GONE else android.view.View.VISIBLE
            }
        )
    }
}
