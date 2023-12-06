package com.tobeto.rentACar.services.dtos.responses.employee;

import com.tobeto.rentACar.services.dtos.responses.role.GetRoleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByEmployeeResponse {

    private String firstName;
    private String lastName;
    private GetRoleResponse role;


}
