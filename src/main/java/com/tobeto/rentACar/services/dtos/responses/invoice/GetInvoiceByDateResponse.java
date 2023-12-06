package com.tobeto.rentACar.services.dtos.responses.invoice;

import com.tobeto.rentACar.services.dtos.responses.employee.GetByEmployeeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceByDateResponse {

    private int id;
    private double totalPrice;
    private GetByEmployeeResponse employee;

}
