package com.ups.oop.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 public class InvoiceDTO {
    private Long id;
    private ClientDTO client;
    private EmployeeDTO employee;
    private StoreDTO store;
    private String date;
    private List<InvoiceDetailDTO> invoiceDetails;
}

