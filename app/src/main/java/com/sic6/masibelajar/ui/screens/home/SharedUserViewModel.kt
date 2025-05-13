package com.sic6.masibelajar.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sic6.masibelajar.domain.dao.SharedUserDao
import com.sic6.masibelajar.domain.entities.SharedUser
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SharedUserViewModel @Inject constructor(  private val sharedUserDao: SharedUserDao ) : ViewModel() {
    private val _sharedUsers = MutableStateFlow<List<SharedUser>>(emptyList())
    val sharedUsers: StateFlow<List<SharedUser>> = _sharedUsers

    init {
        viewModelScope.launch {
            _sharedUsers.value = sharedUserDao.getSharedUsers()
        }
    }

    fun addSharedUser(email: String) {
        viewModelScope.launch {
            val user = SharedUser(
                id = email.hashCode(),
                email = email,
                url = ""
            )
            sharedUserDao.insertSharedUser(user)
            _sharedUsers.value = sharedUserDao.getSharedUsers()
        }
    }

    fun deleteAllSharedUsers() {
        viewModelScope.launch {
            sharedUserDao.deleteSharedUser()
            _sharedUsers.value = emptyList()
        }
    }
}