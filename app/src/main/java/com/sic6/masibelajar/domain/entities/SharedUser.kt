package com.sic6.masibelajar.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shared_users")
data class SharedUser(
    @PrimaryKey val email: String
)