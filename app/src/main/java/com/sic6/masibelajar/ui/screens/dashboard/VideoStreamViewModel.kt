package com.sic6.masibelajar.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sic6.masibelajar.data.remote.WebSocketManager
import com.sic6.masibelajar.domain.entities.VideoStreamRequest
import com.sic6.masibelajar.domain.entities.VideoStreamResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WebSocketViewModel : ViewModel() {

    private val webSocketManager = WebSocketManager("ws://10.33.35.199:8000/v1/main-con")

    private val _response = MutableStateFlow<VideoStreamResponse?>(null)
    val response = _response.asStateFlow()

    init {
        viewModelScope.launch {
            webSocketManager.disconnect()
            webSocketManager.connect()
            webSocketManager.messages.collect { message ->
                _response.value = message
            }
        }
    }

    fun send(message: VideoStreamRequest) {
        message.url = "http://${message.url}:81/stream"
        webSocketManager.send(message)
    }

    override fun onCleared() {
        super.onCleared()
        webSocketManager.disconnect()
    }
}
