package com.tobeto.rentACar.dtos.requests.model;

import com.tobeto.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {

    private String name;
    private int year;
    private Brand brand;
}
