package com.mcvector36.reportloto.ui.pachet5din40

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Model5din40 : ViewModel() {
    private val _uri = MutableLiveData<Uri>().apply {
        value = Uri.parse("https://www.loto.ro/loto-new/newLotoSiteNexioFinalVersion/web/app2.php/jocuri/540_si_super_noroc/rezultate_extrageri.html")
    }
    val uri: LiveData<Uri> = _uri
}