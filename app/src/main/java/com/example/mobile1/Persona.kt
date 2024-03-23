package com.example.mobile1
import java.util.UUID

data class Persona(
    val id: UUID = UUID.randomUUID(),
    val nombre: String,
    val edad: Int
)