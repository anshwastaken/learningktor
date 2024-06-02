package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val id : Int,
    val name : String,
    val speciality : String,
    val experience : String,
    val gender : String,
    val availability : String,
    val address : String
)
