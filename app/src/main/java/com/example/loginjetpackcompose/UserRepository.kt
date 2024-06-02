package com.example.loginjetpackcompose

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(context: Context) {
    private val userDao = AppDatabase.getDatabase(context).userDao()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun getUserByEmailAndPassword(email: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUserByEmailAndPassword(email, password)
        }
    }
}