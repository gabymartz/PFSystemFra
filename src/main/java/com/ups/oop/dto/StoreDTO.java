package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreDTO {
    private String id;
    private String name;
    private String address;
    private BranchDTO branch;
}
