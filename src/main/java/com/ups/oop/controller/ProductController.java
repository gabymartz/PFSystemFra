package com.ups.oop.controller;

import com.ups.oop.dto.ProductDTO;
import com.ups.oop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all-products")
    public ResponseEntity getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/get-product")
    public ResponseEntity getProductById(@RequestParam String productId) {
        return this.productService.getProductById(productId);
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.createProduct(productDTO);
    }

    @PutMapping("/update-product")
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.updateProduct(productDTO);
    }

    @DeleteMapping("/remove-product")
    public ResponseEntity deleteProductById(@RequestParam String productId) {
        return this.productService.deleteProductById(productId);
    }
}
