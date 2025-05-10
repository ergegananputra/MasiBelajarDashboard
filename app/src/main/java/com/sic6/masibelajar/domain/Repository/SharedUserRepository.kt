package com.sic6.masibelajar.domain.Repository

import com.sic6.masibelajar.domain.dao.SharedUserDao
import com.sic6.masibelajar.domain.entities.SharedUser
import kotlinx.coroutines.flow.Flow

class SharedUserRepository(private val dao: SharedUserDao) {
    val allUsers: Flow<List<SharedUser>> = dao.getAll()

    suspend fun addUser(user: SharedUser) = dao.insert(user)
    suspend fun deleteUser(user: SharedUser) = dao.delete(user)
}
