package com.sic6.masibelajar.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sic6.masibelajar.data.remote.WebSocketManager
import com.sic6.masibelajar.domain.entities.VideoStreamResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WebSocketViewModel : ViewModel() {

    private val webSocketManager = WebSocketManager("ws://xxx.xxxx.xx.xxx:8000/v1/stream") // change this

    private val _response = MutableStateFlow<VideoStreamResponse?>(null)
    val response = _response.asStateFlow()

    init {
//        viewModelScope.launch {
//            webSocketManager.connect()
//            webSocketManager.messages.collect { message ->
//                _response.value = message
//            }
//        }
    }

    fun send(message: String) {
        webSocketManager.send(message)
    }

    override fun onCleared() {
        super.onCleared()
        webSocketManager.disconnect()
    }
}
