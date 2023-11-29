package com.tobeto.rentACar.services.dtos.requests.rental;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    private Car car;
    private User user;

}
