package com.example.roomapp.model

import androidx.lifecycle.LiveData
import com.example.roomapp.db.User
import com.example.roomapp.db.UserDao

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}