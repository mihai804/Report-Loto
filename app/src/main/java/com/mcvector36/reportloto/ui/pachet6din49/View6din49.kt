package com.mcvector36.reportloto.ui.pachet6din49


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mcvector36.reportloto.databinding.Grafica6din49Binding
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient


class View6din49 : Fragment() {

    private var _binding: Grafica6din49Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model6din49 =
            ViewModelProvider(this).get(Model6din49::class.java)

        _binding = Grafica6din49Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView: WebView = binding.webView6din49
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        webView.webViewClient = WebViewClient()

        model6din49.uri.observe(viewLifecycleOwner) {
            webView.loadUrl(it.toString())
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}