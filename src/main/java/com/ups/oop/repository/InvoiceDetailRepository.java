package com.ups.oop.repository;

import com.ups.oop.entity.Invoice;
import com.ups.oop.entity.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail, Long> {
    List<InvoiceDetail> findByInvoice(Invoice invoice);
}
