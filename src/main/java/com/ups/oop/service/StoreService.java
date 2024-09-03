package com.ups.oop.service;

import com.ups.oop.dto.StoreDTO;
import com.ups.oop.entity.Store;
import com.ups.oop.repository.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public ResponseEntity createStore(StoreDTO storeDTO) {
        Store store = new Store();
        store.setStoreName(storeDTO.getStoreName());
        store.setStoreLocation(storeDTO.getStoreLocation());
        storeRepository.save(store);
        return ResponseEntity.status(HttpStatus.CREATED).body(storeDTO);
    }

    public ResponseEntity getAllStores() {
        Iterable<Store> stores = storeRepository.findAll();
        List<StoreDTO> storeDTOList = new ArrayList<>();
        for (Store store : stores) {
            StoreDTO dto = new StoreDTO(
                    store.getId(),store.getStoreName(),store.getStoreLocation()
            );
            storeDTOList.add(dto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(storeDTOList);
    }

    public ResponseEntity getStoreById(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isPresent()) {
            StoreDTO dto = new StoreDTO(store.get().getId(), store.get().getStoreName(), store.get().getStoreLocation());
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found");
        }
    }

    public ResponseEntity updateStore(Long id, StoreDTO storeDTO) {
        Optional<Store> existingStore = storeRepository.findById(id);
        if (existingStore.isPresent()) {
            Store store = existingStore.get();
            store.setStoreName(storeDTO.getStoreName());
            store.setStoreLocation(storeDTO.getStoreLocation());
            storeRepository.save(store);
            return ResponseEntity.status(HttpStatus.OK).body(storeDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found");
        }
    }

    public ResponseEntity deleteStore(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if (store.isPresent()) {
            storeRepository.delete(store.get());
            return ResponseEntity.status(HttpStatus.OK).body("Store deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found");
        }
    }
}
