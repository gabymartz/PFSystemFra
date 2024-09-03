package com.ups.oop.service;

import com.ups.oop.dto.EmployeeDTO;
import com.ups.oop.entity.Employee;
import com.ups.oop.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        employee.setPersonId(employeeDTO.getId().toString());
        employee.setName(employeeDTO.getName());
        employee.setLastname("");
        employee.setAge(employeeDTO.getAge());
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }

    public ResponseEntity getAllEmployees() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO dto = new EmployeeDTO(employee.getId(), employee.getName(), employee.getAge(), employee.getEmployeeCode());
            employeeDTOList.add(dto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeDTOList);
    }

    public ResponseEntity getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            EmployeeDTO dto = new EmployeeDTO(employee.get().getId(), employee.get().getName(), employee.get().getAge(), employee.get().getEmployeeCode());
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    public ResponseEntity getEmployeeByPersonId(String personId) {
        Optional<Employee> employee = employeeRepository.findByPersonId(personId);
        if (employee.isPresent()) {
            EmployeeDTO dto = new EmployeeDTO(employee.get().getId(), employee.get().getName(), employee.get().getAge(), employee.get().getEmployeeCode());
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    public ResponseEntity updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setEmployeeCode(employeeDTO.getEmployeeCode());
            employee.setName(employeeDTO.getName());
            employee.setAge(employeeDTO.getAge());
            employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    public ResponseEntity deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
            return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }
}
