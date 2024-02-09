package com.mcvector36.reportloto.ui.pachetjoker

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ModelJoker : ViewModel() {

    private val _uri = MutableLiveData<Uri>().apply {
      value = Uri.parse("https://www.loto.ro/?p=3899")
    }
    val uri: LiveData<Uri> = _uri
}