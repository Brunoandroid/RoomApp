package com.example.roomapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

// Interface Dao

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>  // Captura todos os dados da Entidade que esta no db
}