package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 public class ProductDTO {
   private Long id;
   private String productId;
   private String name;
   private double price;
   private double interestRate;
   private Long supplierId;
}

