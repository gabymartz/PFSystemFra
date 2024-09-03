package com.ups.oop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String productId;
   private String name;
   private double price;

   private double interestRate;

   @ManyToOne
   @JoinColumn(name = "supplier_id", nullable = true)
   private Supplier supplier;

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", productId='" + productId + '\'' +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", interestRate=" + interestRate +
            ", supplierName=" + (supplier != null ? supplier.getName() : "No Supplier") +
            '}';
  }
}
