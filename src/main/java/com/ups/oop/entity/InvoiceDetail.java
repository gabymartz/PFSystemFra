package com.ups.oop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 public class InvoiceDetail {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "invoice_id", nullable = false)
   private Invoice invoice;

   @ManyToOne
   @JoinColumn(name = "client_id", nullable = false)
   private Client client;

   @ManyToOne
   @JoinColumn(name = "branch_id", nullable = false)
   private Branch branch;

   @ManyToOne
   @JoinColumn(name = "store_id", nullable = false)
   private Store store;

   @ManyToOne
   @JoinColumn(name = "product_id", nullable = false)
   private Product product;

   @ManyToOne
   @JoinColumn(name = "supplier_id", nullable = false)
   private Supplier supplier;

   @ManyToOne
   @JoinColumn(name = "payment_id", nullable = false)
   private PaymentMeth paymentMeth;

   private Integer quantity;
   private Integer total;
   private Double interestRate;
}
