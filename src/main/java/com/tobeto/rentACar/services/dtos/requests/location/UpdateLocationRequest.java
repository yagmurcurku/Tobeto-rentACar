package com.tobeto.rentACar.services.dtos.requests.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationRequest {

    private int id;
    private String city;
    private String branchOffice;
    private String officePhone;

}
