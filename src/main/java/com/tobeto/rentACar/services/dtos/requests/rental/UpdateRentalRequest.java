package com.tobeto.rentACar.services.dtos.requests.rental;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    @NotNull(message = "Girilen id'ye ait güncellenecek kiralama verisi bulunamadı !")
    private int id;

    private Car car;
    private User user;

}
