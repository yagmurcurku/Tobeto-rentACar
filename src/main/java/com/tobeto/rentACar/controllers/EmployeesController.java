package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Employee;
import com.tobeto.rentACar.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id){
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee){
        Employee employeeToUpdate = employeeRepository.findById(employee.getId()).orElseThrow();
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setPhone(employee.getPhone());
        employeeToUpdate.setEmail(employee.getEmail());
        employeeToUpdate.setBirthDate(employee.getBirthDate());
        employeeToUpdate.setGender(employee.getGender());
        employeeToUpdate.setIdentificationNumber(employee.getIdentificationNumber());
        employeeToUpdate.setLocation(employee.getLocation());
        employeeToUpdate.setRole(employee.getRole());
        employeeToUpdate.setInvoices(employee.getInvoices());
        employeeToUpdate.setRentalDetails(employee.getRentalDetails());
        employeeRepository.save(employeeToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        employeeRepository.deleteById(id);
    }

}
