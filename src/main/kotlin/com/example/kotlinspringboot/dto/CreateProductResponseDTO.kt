package com.example.kotlinspringboot.dto

import java.time.LocalDateTime
import java.util.*

data class CreateProductResponseDTO(val productId: UUID, val createdAt: LocalDateTime)