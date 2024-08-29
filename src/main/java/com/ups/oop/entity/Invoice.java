package com.ups.oop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.ssl.PemSslBundleProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

 public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private PemSslBundleProperties.Store store;

    private String date;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails = new ArrayList<>();

    public double calculateTotalWithTax(){
        return invoiceDetails.stream()
                .mapToDouble(InvoiceDetail:: getTotalWithTax)
                .sum();
    }

}
