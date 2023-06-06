package com.example.kotlinspringboot.dto

import java.time.LocalDateTime
import java.util.*

data class GetProductResponseDTO(val id: UUID, val name: String, val price: Double, val createdAt: LocalDateTime)
