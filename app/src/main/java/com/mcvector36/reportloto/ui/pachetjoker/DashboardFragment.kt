package com.mcvector36.reportloto.ui.pachetjoker


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mcvector36.reportloto.databinding.FragmentDashboardBinding
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView: WebView = binding.webViewJoker
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        webView.webViewClient = WebViewClient()

        dashboardViewModel.uri.observe(viewLifecycleOwner) {
            webView.loadUrl(it.toString())
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



/*
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mcvector36.reportloto.ui.ui.ReportLotoTheme

class ReportJoker : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReportLotoTheme {
                // A surface container using the 'background' color from the ui
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WebJoker()
                }
            }
        }
    }
}

@Composable
fun WebJoker() {


    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                // Setarea cache-ului
                settings.domStorageEnabled
                settings.allowContentAccess
                settings.allowUniversalAccessFromFileURLs
                settings.allowFileAccess
                settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK) // Va încărca paginile din cache, dar va folosi rețeaua dacă nu sunt disponibile în cache



                loadUrl("https://www.loto.ro/?p=3899") // Înlocuiește cu URL-ul paginii web dorite
            }
        },
        update = { view ->
            view.loadUrl("https://www.loto.ro/?p=3899") // Înlocuiește cu URL-ul paginii web dorite
        }
    )
}

*/
