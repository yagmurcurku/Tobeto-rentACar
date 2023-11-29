package com.tobeto.rentACar.services.dtos.responses.invoice;

import com.tobeto.rentACar.entities.Employee;
import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceListResponse {

    private int id;
    private double totalPrice;
    private LocalDate invoiceDate;
    private Rental rental;
    private PaymentMethod paymentMethod;
    private Employee employee;

}
