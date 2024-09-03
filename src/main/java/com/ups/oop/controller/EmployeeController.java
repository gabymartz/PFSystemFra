package com.ups.oop.controller;

import com.ups.oop.dto.EmployeeDTO;
import com.ups.oop.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-all-employees")
    public ResponseEntity getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/get-employee")
    public ResponseEntity getEmployeeById(@RequestParam Long id) {
        return this.employeeService.getEmployeeById(id);
    }

    @GetMapping("/get-employee-by-person-id")
    public ResponseEntity getEmployeeByPersonId(@RequestParam String personId) {
        return this.employeeService.getEmployeeByPersonId(personId);
    }

    @PostMapping("/employee")
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return this.employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/update-employee")
    public ResponseEntity updateEmployee(@RequestParam Long id, @RequestBody EmployeeDTO employeeDTO) {
        return this.employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/remove-employee")
    public ResponseEntity deleteEmployee(@RequestParam Long id) {
        return this.employeeService.deleteEmployee(id);
    }
}
