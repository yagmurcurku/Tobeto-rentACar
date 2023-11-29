package com.tobeto.rentACar.services.dtos.requests.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleRequest {

    private int id;
    private String name;

}
