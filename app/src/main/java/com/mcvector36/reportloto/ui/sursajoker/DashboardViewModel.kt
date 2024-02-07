package com.mcvector36.reportloto.ui.sursajoker
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is sursajoker Fragment"
    }
    val text: LiveData<String> = _text
}