package com.ups.oop.service;

import com.ups.oop.dto.InvoiceDTO;
import com.ups.oop.entity.Invoice;
import com.ups.oop.entity.InvoiceDetail;
import com.ups.oop.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDTO> getAllInvoices() {
        Iterable<Invoice> invoiceIterable = invoiceRepository.findAll();
        List<InvoiceDTO> invoiceList = new ArrayList<>();

        for (Invoice invoice : invoiceIterable) {
            InvoiceDTO invoiceDTO = new InvoiceDTO();
            invoiceDTO.setId(invoice.getId().toString());
            invoiceDTO.setSerial(invoice.getSerial());
            invoiceDTO.setClient(invoice.getClient().getName() + " " + invoice.getClient().getLastname());
            invoiceDTO.setDate(invoice.getDate());
            invoiceDTO.setTotalPrice(invoice.getInvoiceDetails().stream().mapToDouble(InvoiceDetail::getTotal).sum());
            invoiceDTO.setPaymentMethod(invoice.getPaymentMeth().getMethod());

            invoiceList.add(invoiceDTO);
        }

        return invoiceList;
    }
}
