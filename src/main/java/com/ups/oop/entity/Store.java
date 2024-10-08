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

 public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   private String storeName;
   private String storeLocation;

   @OneToMany(mappedBy = "store")
   private List<Branch> branches = new ArrayList<>();
}
