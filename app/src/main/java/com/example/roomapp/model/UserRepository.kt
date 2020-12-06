package com.example.roomapp.model

import androidx.lifecycle.LiveData
import com.example.roomapp.db.User
import com.example.roomapp.db.UserDao

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    // Método adicionar User
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}