package com.example.roomapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomapp.db.User
import com.example.roomapp.db.UserDatabase
import com.example.roomapp.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    // Captura todos os dados da Entidade que esta no db
    val readAllData: LiveData<List<User>> // LiveData
    private val repository: UserRepository // Repositório

    // Inicializa os valores
    init {
        // Captura o Dao do Database
        val userDao = UserDatabase.getDatabase(application.baseContext).userDao()
        repository = UserRepository(userDao) // Repositorio recebe o Dao
        readAllData = repository.readAllData // Captura todos os dados da tabela
    }


    // Adiciona um novo User
    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    // Atualiza Usuario
    fun updateUser(user:User){
        viewModelScope.launch { Dispatchers.IO
            repository.updateUser(user)
        }
    }

    // Deleta Usuario
    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteUser(user)
        }
    }

    // Deleta todos Usuarios
    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllUsers()
        }
    }

}