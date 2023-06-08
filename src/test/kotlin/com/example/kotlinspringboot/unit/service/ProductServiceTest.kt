package com.example.kotlinspringboot.unit.service

import com.example.kotlinspringboot.dto.CreateProductRequestDTO
import com.example.kotlinspringboot.service.ProductService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.web.server.ResponseStatusException
import java.util.*

class ProductServiceTest {
    private val productService = ProductService()

    @Test
    fun creatingNewProductShouldReturnCorrectResponseDTO() {
        val requestDTO = CreateProductRequestDTO("Tomato", 1.23)
        val responseDTO = productService.createProduct(requestDTO)
        Assertions.assertNotNull(responseDTO)
        Assertions.assertNotNull(responseDTO.productId)
        Assertions.assertNotNull(responseDTO.createdAt)
    }

    @Test
    fun fetchingProductWithFakeIdShouldThrowException() {
        val fakeId = UUID.fromString("c8bc1ab7-b8cc-4653-838f-e09b636fc105")
        Assertions.assertThrows(ResponseStatusException::class.java) {productService.getProductById(fakeId)}
    }
}