package com.ups.oop.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 public class InvoiceDetailDTO {
    private Long id;
    private int quantity;
    private double subtotal;
    private ProductDTO product;
    private double totalWithTax;
}

