package com.ups.oop.controller;

import com.ups.oop.dto.SupplierDTO;
import com.ups.oop.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/get-all-suppliers")
    public ResponseEntity getAllSuppliers() {
        return this.supplierService.getAllSuppliers();
    }

    @GetMapping("/get-supplier")
    public ResponseEntity getSupplierById(@RequestParam String id) {
        return this.supplierService.getSupplierById(id);
    }

    @PostMapping("/create-supplier")
    public ResponseEntity createSupplier(@RequestBody SupplierDTO supplierDTO) {
        return this.supplierService.createSupplier(supplierDTO);
    }

    @PutMapping("/update-supplier")
    public ResponseEntity updateSupplier(@RequestParam String id, @RequestBody SupplierDTO supplierDTO) {
        return this.supplierService.updateSupplier(id, supplierDTO);
    }

    @DeleteMapping("/remove-supplier")
    public ResponseEntity deleteSupplier(@RequestParam String id) {
        return this.supplierService.deleteSupplier(id);
    }
}
