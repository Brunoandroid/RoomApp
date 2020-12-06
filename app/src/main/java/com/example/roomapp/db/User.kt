package com.example.roomapp.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Entidade Room

@Parcelize

//Criação da tabela
@Entity(tableName = "user_table")
//Atributos da tabela
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firsName: String,
    val lastName: String,
    val age: Int
): Parcelable
