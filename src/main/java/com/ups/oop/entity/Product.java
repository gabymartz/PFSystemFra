package com.ups.oop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private double unitPrice;
    private boolean hasTax;
    private double taxRate;
    private String suppliersS;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
    private Supplier supplier;

    @ManyToMany
    @JoinTable(
            name= "product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> suppliers = new ArrayList<>();

    public double getPriceWithTax(){
       return hasTax ? unitPrice * (1 + taxRate) : unitPrice;
    }
}
