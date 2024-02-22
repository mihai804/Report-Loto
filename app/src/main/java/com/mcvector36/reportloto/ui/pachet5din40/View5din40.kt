package com.mcvector36.reportloto.ui.pachet5din40

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mcvector36.reportloto.databinding.Grafica5din40Binding
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class View5din40 : Fragment() {
    private var _binding: Grafica5din40Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model5din40 =
            ViewModelProvider(this).get(Model5din40::class.java)

        _binding = Grafica5din40Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView: WebView = binding.webView5din40
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        webView.webViewClient = WebViewClient()

        model5din40.uri.observe(viewLifecycleOwner) {
            webView.loadUrl(it.toString())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}