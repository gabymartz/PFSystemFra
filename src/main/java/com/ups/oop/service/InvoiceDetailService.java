package com.ups.oop.service;

import com.ups.oop.dto.InvoiceDetailDTO;
import com.ups.oop.entity.InvoiceDetail;
import com.ups.oop.repository.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceDetailService {
    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public List<InvoiceDetailDTO> getAllInvoiceDetails() {
        Iterable<InvoiceDetail> detailIterable = invoiceDetailRepository.findAll();
        List<InvoiceDetailDTO> detailList = new ArrayList<>();

        for (InvoiceDetail detail : detailIterable) {
            InvoiceDetailDTO detailDTO = new InvoiceDetailDTO();
            detailDTO.setSerial(detail.getInvoice().getSerial());
            detailDTO.setClient(detail.getClient().getName() + " " + detail.getClient().getLastname());
            detailDTO.setBranch(detail.getBranch().getBranchName());
            detailDTO.setStore(detail.getStore().getStoreName());
            detailDTO.setProductName(detail.getProduct().getName());
            detailDTO.setProductPrice(detail.getProduct().getPrice());
            detailDTO.setQuantity(detail.getQuantity());
            detailDTO.setTotal(detail.getTotal());
            detailDTO.setInterestRate(detail.getInterestRate());
            detailDTO.setSupplier(detail.getSupplier().getName());
            detailDTO.setPaymentMethod(detail.getPaymentMeth().getMethod());
            detailDTO.setEmployee(detail.getEmployee().getName() + " " + detail.getEmployee().getLastname()); // Asegúrate de que el nombre del empleado se extrae correctamente


            detailList.add(detailDTO);
        }

        return detailList;
    }
}
