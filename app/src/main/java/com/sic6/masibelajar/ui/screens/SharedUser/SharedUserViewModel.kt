package com.sic6.masibelajar.ui.screens.SharedUser

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sic6.masibelajar.data.local.AppDatabase
import com.sic6.masibelajar.domain.Repository.SharedUserRepository
import com.sic6.masibelajar.domain.entities.SharedUser
import kotlinx.coroutines.launch

class SharedUserViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).sharedUserDao()
    private val repository = SharedUserRepository(dao)

    val sharedUsers = repository.allUsers.asLiveData()

    fun addUser(email: String) {
        viewModelScope.launch {
            repository.addUser(SharedUser(email = email))
        }
    }
}
