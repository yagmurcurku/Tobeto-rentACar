package com.tobeto.rentACar.services.dtos.responses.rental;

import com.tobeto.rentACar.entities.User;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByRentalResponse {

    private GetByCarResponse car;

}
