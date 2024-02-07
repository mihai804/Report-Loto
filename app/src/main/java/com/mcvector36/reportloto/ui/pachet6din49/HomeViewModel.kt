package com.mcvector36.reportloto.ui.pachet6din49

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

class HomeViewModel : ViewModel() {

    private val _uri = MutableLiveData<Uri>().apply {
        value = Uri.parse("https://www.loto.ro/?p=3872")
    }
    val uri: LiveData<Uri> = _uri
}