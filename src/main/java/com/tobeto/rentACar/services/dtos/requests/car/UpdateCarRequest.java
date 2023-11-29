package com.tobeto.rentACar.services.dtos.requests.car;

import com.tobeto.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    private int id;
    private String plate;
    private double dailyPrice;
    private boolean state;
    private Model model;

}