package com.example.roomapp.repository

import androidx.lifecycle.LiveData
import com.example.roomapp.db.User
import com.example.roomapp.db.UserDao

class UserRepository(private val userDao: UserDao) {

    // Captura todos os dados da Entidade que esta no db
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    // Adicionar Usuario
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    // Atualiza Usuario
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    // Delete Usuario
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    // Deleta todos Usuarios
    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }
}