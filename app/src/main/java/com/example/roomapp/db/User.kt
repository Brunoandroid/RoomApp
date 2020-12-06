package com.example.roomapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entidade Room

//Criação da tabela
@Entity(tableName = "user_table")
//Atributos da tabela
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firsName: String,
    val lastName: String,
    val age: Int
)
