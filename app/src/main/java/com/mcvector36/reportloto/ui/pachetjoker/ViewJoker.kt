package com.mcvector36.reportloto.ui.pachetjoker


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mcvector36.reportloto.databinding.GraficaJokerBinding
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class ViewJoker : Fragment() {

    private var _binding: GraficaJokerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val modelJoker =
            ViewModelProvider(this).get(ModelJoker::class.java)

        _binding = GraficaJokerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView: WebView = binding.webViewJoker
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        webView.webViewClient = WebViewClient()

        modelJoker.uri.observe(viewLifecycleOwner) {
            webView.loadUrl(it.toString())
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
