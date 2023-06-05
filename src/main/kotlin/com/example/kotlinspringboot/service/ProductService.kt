package com.example.kotlinspringboot.service

import com.example.kotlinspringboot.dto.CreateProductRequestDTO
import com.example.kotlinspringboot.dto.CreateProductResponseDTO
import com.example.kotlinspringboot.dto.GetProductResponseDTO
import com.example.kotlinspringboot.model.Product
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ProductService {
    private val products: MutableList<Product> = mutableListOf()

    fun getProducts(): GetProductResponseDTO {
        return GetProductResponseDTO(products);
    }

    fun createProduct(dto: CreateProductRequestDTO): CreateProductResponseDTO {
        val id: UUID = UUID.randomUUID()
        val createdAt = LocalDateTime.now()
        products.add(Product(id, dto.name, dto.price, createdAt))
        return CreateProductResponseDTO(id, createdAt);
    }
}