package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.rentACar.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.rentACar.services.dtos.responses.paymentMethod.GetPaymentMethodListResponse;
import com.tobeto.rentACar.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {

    List<GetPaymentMethodListResponse> getAll();
    GetPaymentMethodResponse getById(int id);
    void add(AddPaymentMethodRequest addPaymentMethodRequest);
    void update(UpdatePaymentMethodRequest updatePaymentMethodRequest);
    void delete(int id);

}
