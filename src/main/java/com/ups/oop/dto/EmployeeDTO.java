package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
 public class EmployeeDTO {
    private Long id;
    private String name;
    private Integer age;
    private String employeeCode;
}
