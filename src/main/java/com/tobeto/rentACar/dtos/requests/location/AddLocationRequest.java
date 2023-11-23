package com.tobeto.rentACar.dtos.requests.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLocationRequest {

    private String city;
    private String branchOffice;
    private String officePhone;

}
