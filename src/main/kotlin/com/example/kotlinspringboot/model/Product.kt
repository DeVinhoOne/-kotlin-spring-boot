package com.example.kotlinspringboot.model

import java.time.LocalDateTime
import java.util.UUID

class Product(val id: UUID, val name: String, val price: Double, val createdAt: LocalDateTime)