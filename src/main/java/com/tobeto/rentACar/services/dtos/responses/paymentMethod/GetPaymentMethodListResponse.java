package com.tobeto.rentACar.services.dtos.responses.paymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentMethodListResponse {

    private int id;
    private String name;

}
