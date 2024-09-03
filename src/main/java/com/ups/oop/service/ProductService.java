package com.ups.oop.service;

import com.ups.oop.dto.ProductDTO;
import com.ups.oop.entity.Product;
import com.ups.oop.entity.Supplier;
import com.ups.oop.repository.ProductRepository;
import com.ups.oop.repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public ResponseEntity createProduct(ProductDTO productDTO) {
        String productId = productDTO.getProductId();
        Optional<Product> productOptional = productRepository.findByProductId(productId);

        if (productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product with id " + productId + " already exists");
        } else {
            Product product = new Product();
            product.setProductId(productId);
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setInterestRate(productDTO.getInterestRate());

            if (productDTO.getSupplierId() != null) {
                Optional<Supplier> supplierOptional = supplierRepository.findById(productDTO.getSupplierId());
                if (supplierOptional.isPresent()) {
                    product.setSupplier(supplierOptional.get());
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Supplier with id " + productDTO.getSupplierId() + " not found");
                }
            }

            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        }
    }

    public ResponseEntity getAllProducts() {
        List<ProductDTO> productList = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();

        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getProductId(),
                    product.getName(),
                    product.getPrice(),
                    product.getInterestRate(),
                    product.getSupplier() != null ? product.getSupplier().getId() : null
            );
            productList.add(productDTO);
        }

        if (productList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    public ResponseEntity getProductById(String productId) {
        Optional<Product> productOptional = productRepository.findByProductId(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getProductId(),
                    product.getName(),
                    product.getPrice(),
                    product.getInterestRate(),
                    product.getSupplier() != null ? product.getSupplier().getId() : null
            );
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id " + productId + " not found");
        }
    }

    public ResponseEntity updateProduct(ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(productDTO.getId());

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setProductId(productDTO.getProductId());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setInterestRate(productDTO.getInterestRate());

            if (productDTO.getSupplierId() != null) {
                Optional<Supplier> supplierOptional = supplierRepository.findById(productDTO.getSupplierId());
                if (supplierOptional.isPresent()) {
                    product.setSupplier(supplierOptional.get());
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Supplier with id " + productDTO.getSupplierId() + " not found");
                }
            } else {
                product.setSupplier(null);
            }

            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id " + productDTO.getId() + " not found");
        }
    }

    public ResponseEntity deleteProductById(String productId) {
        Optional<Product> productOptional = productRepository.findByProductId(productId);

        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Product with id " + productId + " removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id " + productId + " not found");
        }
    }
}
