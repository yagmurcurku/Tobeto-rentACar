package com.tobeto.rentACar.dtos.responses.rental;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalResponse {

    private Car car;
    private User user;

}
