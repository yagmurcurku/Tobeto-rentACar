package com.tobeto.rentACar.services.dtos.requests.car;

import com.tobeto.rentACar.entities.Model;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @NotBlank(message = "Plaka boş geçilemez !")
    @Size(min = 7, max = 12, message = "Plaka uzunluğu 7 ile 12 karakter aralığında olmalı !")
    private String plate;

    @DecimalMin(value = "1")
    @NotNull
    private double dailyPrice;

    @NotNull        //boolean veri tipinde @NotBlank kullanılmaz.
    private boolean state;

    private Model model;

}

