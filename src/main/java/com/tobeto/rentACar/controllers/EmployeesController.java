package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.EmployeeService;
import com.tobeto.rentACar.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentACar.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentACar.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentACar.services.dtos.responses.employee.GetEmployeeResponse;
import com.tobeto.rentACar.entities.Employee;
import com.tobeto.rentACar.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeesController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<GetEmployeeListResponse> getAll(){
       return employeeService.getAll();
    }

    @GetMapping("{id}")
    public GetEmployeeResponse getById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddEmployeeRequest addEmployeeRequest){
        employeeService.add(addEmployeeRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }

}
