package com.example.kotlinspringboot.service

import com.example.kotlinspringboot.dto.CreateProductRequestDTO
import com.example.kotlinspringboot.dto.CreateProductResponseDTO
import com.example.kotlinspringboot.dto.GetProductResponseDTO
import com.example.kotlinspringboot.dto.GetProductsResponseDTO
import com.example.kotlinspringboot.model.Product
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime
import java.util.*

@Service
class ProductService {
    private val products: MutableList<Product> = mutableListOf()
    private val log = LoggerFactory.getLogger(javaClass)

    fun getProducts(): GetProductsResponseDTO {
        return GetProductsResponseDTO(products);
    }

    fun getProductById(productId: UUID): GetProductResponseDTO {
        try {
            val filteredProduct: Product = products.first { p -> p.id == productId }
            return GetProductResponseDTO(filteredProduct.id, filteredProduct.name, filteredProduct.price, filteredProduct.createdAt)
        } catch (e: NoSuchElementException) {
            log.error("Product {} not found", productId)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id $productId not found")
        }
    }

    fun createProduct(dto: CreateProductRequestDTO): CreateProductResponseDTO {
        val id: UUID = UUID.randomUUID()
        val createdAt = LocalDateTime.now()
        val product = Product(id, dto.name, dto.price, createdAt)
        products.add(product)
        log.info("Created product {}", product.id);
        return CreateProductResponseDTO(id, createdAt);
    }
}