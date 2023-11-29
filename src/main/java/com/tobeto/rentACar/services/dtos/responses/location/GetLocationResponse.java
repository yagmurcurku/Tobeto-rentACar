package com.tobeto.rentACar.services.dtos.responses.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLocationResponse {

    private String city;
    private String branchOffice;
    private String officePhone;

}
