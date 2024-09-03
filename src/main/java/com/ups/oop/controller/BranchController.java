package com.ups.oop.controller;

import com.ups.oop.dto.BranchDTO;
import com.ups.oop.service.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/get-all-branches")
    public ResponseEntity getAllBranches() {
        return this.branchService.getAllBranches();
    }

    @GetMapping("/get-branch")
    public ResponseEntity getBranchById(@RequestParam Long id) {
        return this.branchService.getBranchById(id);
    }

    @PostMapping("/branch")
    public ResponseEntity createBranch(@RequestBody BranchDTO branchDTO) {
        return this.branchService.createBranch(branchDTO);
    }

    @PutMapping("/update-branch")
    public ResponseEntity updateBranch(@RequestBody BranchDTO branchDTO) {
        return this.branchService.updateBranch(branchDTO.getId(), branchDTO);
    }

    @DeleteMapping("/remove-branch")
    public ResponseEntity deleteBranchById(@RequestParam Long id) {
        return this.branchService.deleteBranch(id);
    }
}
