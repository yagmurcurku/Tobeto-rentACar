package com.tobeto.rentACar.dtos.responses.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLocationListResponse {

    private int id;
    private String city;
    private String branchOffice;
    private String officePhone;

}
