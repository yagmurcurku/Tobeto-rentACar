package com.tobeto.rentACar.services.dtos.requests.rental;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    private int id;
    private Car car;
    private User user;

}
