package com.tobeto.rentACar.services.dtos.responses.user;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarResponse;
import com.tobeto.rentACar.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserResponse {

    private String firstName;
    private String lastName;
    private GetByCarResponse car;


}
