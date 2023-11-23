package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentACar.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentACar.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentACar.dtos.responses.employee.GetEmployeeResponse;
import com.tobeto.rentACar.dtos.responses.location.GetLocationListResponse;
import com.tobeto.rentACar.entities.Employee;
import com.tobeto.rentACar.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @GetMapping
    public List<GetEmployeeListResponse> getAll(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<GetEmployeeListResponse> employeeListResponses = new ArrayList<GetEmployeeListResponse>();
        for (Employee employee: employeeList) {
            GetEmployeeListResponse employeeResponse = new GetEmployeeListResponse();
            employeeResponse.setId(employee.getId());
            employeeResponse.setFirstName(employee.getFirstName());
            employeeResponse.setLastName(employee.getLastName());
            employeeResponse.setPhone(employee.getPhone());
            employeeResponse.setEmail(employee.getEmail());
            employeeResponse.setBirthDate(employee.getBirthDate());
            employeeResponse.setGender(employee.getGender());
            employeeResponse.setIdentificationNumber(employee.getIdentificationNumber());
            employeeResponse.setLocation(employee.getLocation());
            employeeResponse.setRole(employee.getRole());
            employeeListResponses.add(employeeResponse);
        }
        return employeeListResponses;
    }

    @GetMapping("{id}")
    public GetEmployeeResponse getById(@PathVariable int id){
        Employee employee = employeeRepository.findById(id).orElseThrow();
        GetEmployeeResponse dto = new GetEmployeeResponse();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setPhone(employee.getPhone());
        dto.setEmail(employee.getEmail());
        dto.setBirthDate(employee.getBirthDate());
        dto.setGender(employee.getGender());
        dto.setIdentificationNumber(employee.getIdentificationNumber());
        dto.setLocation(employee.getLocation());
        dto.setRole(employee.getRole());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddEmployeeRequest addEmployeeRequest){
        Employee employee = new Employee();
        employee.setFirstName(addEmployeeRequest.getFirstName());
        employee.setLastName(addEmployeeRequest.getLastName());
        employee.setPhone(addEmployeeRequest.getPhone());
        employee.setEmail(addEmployeeRequest.getEmail());
        employee.setBirthDate(addEmployeeRequest.getBirthDate());
        employee.setGender(addEmployeeRequest.getGender());
        employee.setIdentificationNumber(addEmployeeRequest.getIdentificationNumber());
        employee.setLocation(addEmployeeRequest.getLocation());
        employee.setRole(addEmployeeRequest.getRole());
        employeeRepository.save(employee);
    }

    @PutMapping
    public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        Employee employeeToUpdate = employeeRepository.findById(updateEmployeeRequest.getId()).orElseThrow();
        employeeToUpdate.setFirstName(updateEmployeeRequest.getFirstName());
        employeeToUpdate.setLastName(updateEmployeeRequest.getLastName());
        employeeToUpdate.setPhone(updateEmployeeRequest.getPhone());
        employeeToUpdate.setEmail(updateEmployeeRequest.getEmail());
        employeeToUpdate.setBirthDate(updateEmployeeRequest.getBirthDate());
        employeeToUpdate.setGender(updateEmployeeRequest.getGender());
        employeeToUpdate.setIdentificationNumber(updateEmployeeRequest.getIdentificationNumber());
        employeeToUpdate.setLocation(updateEmployeeRequest.getLocation());
        employeeToUpdate.setRole(updateEmployeeRequest.getRole());
        employeeRepository.save(employeeToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        employeeRepository.deleteById(id);
    }

}
