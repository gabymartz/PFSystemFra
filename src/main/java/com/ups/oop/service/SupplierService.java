package com.ups.oop.service;

import com.ups.oop.dto.SupplierDTO;
import com.ups.oop.entity.Product;
import com.ups.oop.entity.Supplier;
import com.ups.oop.repository.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public ResponseEntity createSupplier(SupplierDTO supplierDTO) {
        if (supplierRepository.existsById(Long.parseLong(supplierDTO.getId()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Supplier with id " + supplierDTO.getId() + " already exists");
        } else {
            Supplier supplier = new Supplier();
            supplier.setName(supplierDTO.getName());
            supplier.setContactInfo(supplierDTO.getContactInfo());
            supplier.setPhoneNumber(supplierDTO.getPhoneNumber());

            supplierRepository.save(supplier);
            return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
        }
    }

    public ResponseEntity getAllSuppliers() {
        Iterable<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDTO> supplierDTOList = new ArrayList<>();


        for (Supplier supplier : suppliers) {
            SupplierDTO dto = new SupplierDTO(
                    supplier.getId().toString(),
                    supplier.getName(),
                    supplier.getContactInfo(),
                    supplier.getPhoneNumber(),
                    supplier.getProducts().stream().map(Product::getId).toList()
            );
            supplierDTOList.add(dto);
        }

        if (supplierDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No suppliers found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(supplierDTOList);
    }

    public ResponseEntity getSupplierById(String id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(Long.parseLong(id));

        if (supplierOptional.isPresent()) {
            Supplier supplier = supplierOptional.get();
            SupplierDTO dto = new SupplierDTO(
                    supplier.getId().toString(),
                    supplier.getName(),
                    supplier.getContactInfo(),
                    supplier.getPhoneNumber(),
                    supplier.getProducts().stream().map(Product::getId).toList()
            );
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier with id " + id + " not found");
        }
    }

    public ResponseEntity updateSupplier(String id, SupplierDTO supplierDTO) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(Long.parseLong(id));

        if (supplierOptional.isPresent()) {
            Supplier supplier = supplierOptional.get();
            supplier.setName(supplierDTO.getName());
            supplier.setContactInfo(supplierDTO.getContactInfo());
            supplier.setPhoneNumber(supplierDTO.getPhoneNumber());

            supplierRepository.save(supplier);
            return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier with id " + id + " not found");
        }
    }

    public ResponseEntity deleteSupplier(String id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(Long.parseLong(id));

        if (supplierOptional.isPresent()) {
            supplierRepository.delete(supplierOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Supplier with id " + id + " removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier with id " + id + " not found");
        }
    }
}
