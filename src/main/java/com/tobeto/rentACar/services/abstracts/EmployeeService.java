package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentACar.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentACar.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentACar.services.dtos.responses.employee.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<GetEmployeeListResponse> getAll();
    GetEmployeeResponse getById(int id);
    void add(AddEmployeeRequest addEmployeeRequest);
    void update(UpdateEmployeeRequest updateEmployeeRequest);
    void delete(int id);

}
