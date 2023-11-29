package com.tobeto.rentACar.services.dtos.responses.rentalDetail;

import com.tobeto.rentACar.entities.Employee;
import com.tobeto.rentACar.entities.Location;
import com.tobeto.rentACar.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalDetailResponse {

    private LocalDate startDate;
    private LocalDate endDate;
    private Rental rental;
    private Location locationPickup;
    private Location locationDelivery;
    private Employee employee;

}
