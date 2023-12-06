package com.tobeto.rentACar.services.dtos.responses.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoleByGenderResponse {

    private String roleName;
    private String firstName;
    private String lastName;

}
