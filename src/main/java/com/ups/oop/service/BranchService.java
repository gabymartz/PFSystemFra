package com.ups.oop.service;

import com.ups.oop.dto.BranchDTO;
import com.ups.oop.entity.Branch;
import com.ups.oop.entity.Store;
import com.ups.oop.repository.BranchRepository;
import com.ups.oop.repository.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;

    public BranchService(BranchRepository branchRepository, StoreRepository storeRepository) {
        this.branchRepository = branchRepository;
        this.storeRepository = storeRepository;
    }

    public ResponseEntity createBranch(BranchDTO branchDTO) {
        Optional<Store> store = storeRepository.findById(branchDTO.getStoreId());
        if (store.isPresent()) {
            Branch branch = new Branch();
            branch.setBranchName(branchDTO.getBranchName());
            branch.setCity(branchDTO.getCity());
            branch.setBranchAddress(branchDTO.getBranchAddress());
            branch.setStore(store.get());
            branchRepository.save(branch);
            return ResponseEntity.status(HttpStatus.CREATED).body(branchDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found");
        }
    }

    public ResponseEntity getAllBranches() {
        Iterable<Branch> branches = branchRepository.findAll();
        List<BranchDTO> branchDTOList = new ArrayList<>();
        for (Branch branch : branches) {
            BranchDTO dto = new BranchDTO(branch.getId(), branch.getBranchName(), branch.getCity(), branch.getBranchAddress(), branch.getStore().getId());
            branchDTOList.add(dto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(branchDTOList);
    }

    public ResponseEntity getBranchById(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            BranchDTO dto = new BranchDTO(branch.get().getId(), branch.get().getBranchName(), branch.get().getCity(), branch.get().getBranchAddress(), branch.get().getStore().getId());
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch not found");
        }
    }

    public ResponseEntity updateBranch(Long id, BranchDTO branchDTO) {
        Optional<Branch> existingBranch = branchRepository.findById(id);
        if (existingBranch.isPresent()) {
            Branch branch = existingBranch.get();
            branch.setBranchName(branchDTO.getBranchName());
            branch.setCity(branchDTO.getCity());
            branch.setBranchAddress(branchDTO.getBranchAddress());
            branchRepository.save(branch);
            return ResponseEntity.status(HttpStatus.OK).body(branchDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch not found");
        }
    }

    public ResponseEntity deleteBranch(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            branchRepository.delete(branch.get());
            return ResponseEntity.status(HttpStatus.OK).body("Branch deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch not found");
        }
    }
}
