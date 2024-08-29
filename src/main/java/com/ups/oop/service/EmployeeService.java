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
        String employeeId = employeeDTO.getId();
        Optional<Employee> employeeOptional = employeeRepository.findByPersonId(employeeId);

        if (employeeOptional.isPresent()) {
            String errorMessage = "Employee with id " + employeeId + " already exists";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        } else {
            if (employeeDTO.getName().contains(" ")) {
                Employee employeeRecord = new Employee();
                employeeRecord.setPersonId(employeeDTO.getId());
                String[] nameStrings = employeeDTO.getName().split(" ");
                String name = nameStrings[0];
                String lastname = nameStrings[1];
                employeeRecord.setName(name);
                employeeRecord.setLastname(lastname);
                employeeRecord.setAge(employeeDTO.getAge());
                employeeRecord.setEmployeeCode(employeeDTO.getEmployeeCode());
                employeeRepository.save(employeeRecord);
                return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee name must contain two strings separated by a whitespace");
            }
        }
    }

    public ResponseEntity getAllEmployees() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<EmployeeDTO> employeeList = new ArrayList<>();

        for (Employee e : employeeIterable) {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    e.getPersonId(),
                    e.getName() + " " + e.getLastname(),
                    e.getAge(),
                    e.getEmployeeCode()
            );
            employeeList.add(employeeDTO);
        }

        if (employeeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee list is empty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    public ResponseEntity getEmployeeById(String employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findByPersonId(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    employee.getPersonId(),
                    employee.getName() + " " + employee.getLastname(),
                    employee.getAge(),
                    employee.getEmployeeCode()
            );
            return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
        } else {
            String errorMessage = "Employee with id " + employeeId + " does not exist";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateEmployee(EmployeeDTO employeeDTO) {
        String employeeId = employeeDTO.getId();
        Optional<Employee> employeeOptional = employeeRepository.findByPersonId(employeeId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            if (employeeDTO.getName().contains(" ")) {
                employee.setPersonId(employeeId);
                String[] nameStrings = employeeDTO.getName().split(" ");
                String name = nameStrings[0];
                String lastname = nameStrings[1];
                employee.setName(name);
                employee.setLastname(lastname);
                employee.setAge(employeeDTO.getAge());
                employee.setEmployeeCode(employeeDTO.getEmployeeCode());
                employeeRepository.save(employee);
                return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee name must contain two strings separated by a whitespace");
            }
        } else {
            String errorMessage = "Employee with id " + employeeId + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity deleteEmployeeById(String employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findByPersonId(employeeId);
        if (employeeOptional.isPresent()) {
            employeeRepository.delete(employeeOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Employee with id " + employeeId + " removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with id " + employeeId + " not found");
        }
    }
}
