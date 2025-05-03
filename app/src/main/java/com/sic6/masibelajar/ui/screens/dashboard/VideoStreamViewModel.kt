package com.sic6.masibelajar.ui.screens.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sic6.masibelajar.data.remote.WebSocketManager
import com.sic6.masibelajar.domain.entities.History
import com.sic6.masibelajar.domain.entities.VideoStreamRequest
import com.sic6.masibelajar.domain.entities.VideoStreamResponse
import com.sic6.masibelajar.domain.enums.EventType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VideoStreamViewModel : ViewModel() {

    private val webSocketManager = WebSocketManager("ws://10.33.35.199:8000/v1/main-con")

    private val _response = MutableStateFlow<VideoStreamResponse?>(null)
    val response = _response.asStateFlow()

    private val _history = MutableStateFlow<List<History>>(emptyList())
    val history = _history.asStateFlow()

    private val _lastNotified = MutableStateFlow("")
    val lastNotified = _lastNotified.asStateFlow()

    init {
        viewModelScope.launch {
            webSocketManager.disconnect()
            webSocketManager.connect()
            webSocketManager.messages.collect { message ->
                _response.value = message

                Log.d("websocket", "${message.message} ${message.data.results}")

                val currentTimestamp = message.data.results.timestamp.substring(0, 16)

                if (history.value.isNotEmpty() && history.value.last().time.substring(0, 16) != lastNotified.value) {
                    if (message.data.results.fall) {
                        _history.value += History(
                            type = EventType.FALL,
                            name = "Fall Accident",
                            time = message.data.results.timestamp
                        )
                    } else if (message.data.results.is_there_something_wrong == true) {
                        _history.value += History(
                            type = EventType.MISSING,
                            name = "Someone has been inside the safe zone for an extended period",
                            time = message.data.results.timestamp
                        )
                    }
                    _lastNotified.value = currentTimestamp
                }

            }
        }
    }

    fun send(message: VideoStreamRequest) {
        webSocketManager.send(message)
    }

    override fun onCleared() {
        super.onCleared()
        webSocketManager.disconnect()
    }
}
