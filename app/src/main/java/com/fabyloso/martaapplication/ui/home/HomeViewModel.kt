package com.fabyloso.martaapplication.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fabyloso.martaapplication.data.remote.NetworkResult
import com.fabyloso.martaapplication.data.remote.marta.MartaRemoteSource
import com.fabyloso.martaapplication.data.remote.marta.MartaTrain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val remoteSource: MartaRemoteSource) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    val coroutineContext = Dispatchers.IO
    val scope = CoroutineScope(coroutineContext)

    val trainsLiveData = MutableLiveData<NetworkResult<Array<MartaTrain>>>()
    fun fetchTrains() {
        scope.launch {
            val trains = remoteSource.getTrains()
            trainsLiveData.postValue(trains)
        }
    }
}