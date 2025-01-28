package com.example.myapplication

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name : String,
    val phone : String,
    val email : String,
    val password : String,
)

