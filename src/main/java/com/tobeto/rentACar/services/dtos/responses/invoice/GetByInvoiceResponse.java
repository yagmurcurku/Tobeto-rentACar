package com.tobeto.rentACar.services.dtos.responses.invoice;

import com.tobeto.rentACar.entities.Rental;
import com.tobeto.rentACar.services.dtos.responses.rental.GetByRentalResponse;
import com.tobeto.rentACar.services.dtos.responses.rental.GetRentalResponse;
import com.tobeto.rentACar.services.dtos.responses.user.GetByUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByInvoiceResponse {

    private double totalPrice;
    private LocalDate invoiceDate;
    private GetByRentalResponse rental;

}
