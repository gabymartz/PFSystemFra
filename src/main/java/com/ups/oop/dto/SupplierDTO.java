package com.ups.oop.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
 public class SupplierDTO {
    private String id;
    private String name;
    private String contactInfo;
    private String phoneNumber;
    private List<Long> productIds;
}
