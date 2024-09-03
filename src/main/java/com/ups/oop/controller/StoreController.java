package com.ups.oop.controller;

import com.ups.oop.dto.StoreDTO;
import com.ups.oop.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/get-all-stores")
    public ResponseEntity getAllStores() {
        return this.storeService.getAllStores();
    }

    @GetMapping("/get-store")
    public ResponseEntity getStoreById(@RequestParam Long id) {
        return this.storeService.getStoreById(id);
    }

    @PostMapping("/store")
    public ResponseEntity createStore(@RequestBody StoreDTO storeDTO) {
        return this.storeService.createStore(storeDTO);
    }

    @PutMapping("/update-store/{id}")
    public ResponseEntity updateStore(@PathVariable Long id, @RequestBody StoreDTO storeDTO) {
        return this.storeService.updateStore(id, storeDTO);
    }

    @DeleteMapping("/remove-store")
    public ResponseEntity deleteStore(@RequestParam Long id) {
        return this.storeService.deleteStore(id);
    }
}
