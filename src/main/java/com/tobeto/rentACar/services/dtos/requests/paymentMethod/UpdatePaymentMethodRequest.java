package com.tobeto.rentACar.services.dtos.requests.paymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentMethodRequest {

    private int id;
    private String name;

}
