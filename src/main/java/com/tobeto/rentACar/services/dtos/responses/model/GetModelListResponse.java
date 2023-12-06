package com.tobeto.rentACar.services.dtos.responses.model;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelListResponse {

    private String name;
    private int id;
    private int year;
    //private Brand brand;
    private GetBrandResponse brand;

    public GetModelListResponse(String name){
        this.name = name;
    }

}
