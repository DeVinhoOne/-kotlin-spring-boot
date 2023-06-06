package com.example.kotlinspringboot.controller

import com.example.kotlinspringboot.dto.CreateProductRequestDTO
import com.example.kotlinspringboot.dto.CreateProductResponseDTO
import com.example.kotlinspringboot.dto.GetProductResponseDTO
import com.example.kotlinspringboot.dto.GetProductsResponseDTO
import com.example.kotlinspringboot.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ProductController(private val service: ProductService) {

    @GetMapping("/products")
    fun getProducts(): GetProductsResponseDTO {
        return service.getProducts();
    }

    @GetMapping("/product")
    fun getProductById(@RequestParam(name = "id") productId: String): GetProductResponseDTO {
        return service.getProductById(UUID.fromString(productId));
    }


    @PostMapping("/product/create")
    fun createProduct(@RequestBody dto: CreateProductRequestDTO): CreateProductResponseDTO {
        return service.createProduct(dto)
    }
}