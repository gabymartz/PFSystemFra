package com.ups.oop.repository;

import com.ups.oop.entity.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Long> {
}
