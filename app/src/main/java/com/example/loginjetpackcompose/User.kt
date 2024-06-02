package com.example.loginjetpackcompose

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userName: String,
    val email: String,
    val phoneNumber: String,
    val password: String
)
