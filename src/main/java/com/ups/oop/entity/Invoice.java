package com.ups.oop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
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
    private String serial;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private Date invoiceDate;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentMeth paymentMeth;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails;
}
