package com.example.kotlinspringboot.controller

import com.example.kotlinspringboot.dto.CreateProductRequestDTO
import com.example.kotlinspringboot.dto.CreateProductResponseDTO
import com.example.kotlinspringboot.dto.GetProductResponseDTO
import com.example.kotlinspringboot.model.Product
import com.example.kotlinspringboot.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ProductController(private val service: ProductService) {

    @GetMapping("/products")
    fun getProducts(): GetProductResponseDTO {
        return service.getProducts();
    }

    @PostMapping("/product/create")
    fun createProduct(@RequestBody dto: CreateProductRequestDTO): CreateProductResponseDTO {
        return service.createProduct(dto)
    }
}