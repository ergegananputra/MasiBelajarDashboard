package com.sic6.masibelajar.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sic6.masibelajar.domain.entities.SharedUser
import kotlinx.coroutines.flow.Flow
import androidx.room.OnConflictStrategy



@Dao
interface SharedUserDao {
    @Query("SELECT * FROM shared_users")
    fun getAll(): Flow<List<SharedUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: SharedUser)

    @Delete
    suspend fun delete(user: SharedUser)

    @Query("DELETE FROM shared_users")
    suspend fun deleteAll()
}

