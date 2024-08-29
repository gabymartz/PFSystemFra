package com.ups.oop.repository;

import com.ups.oop.entity.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail, Long> {
}
