package com.mcvector36.reportloto.ui.pachet6din49

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class Model6din49 : ViewModel() {

    private val _uri = MutableLiveData<Uri>().apply {
       value = Uri.parse("https://www.loto.ro/loto-new/newLotoSiteNexioFinalVersion/web/app2.php/jocuri/649_si_noroc/rezultate_extragere.html")
    }
    val uri: LiveData<Uri> = _uri
}