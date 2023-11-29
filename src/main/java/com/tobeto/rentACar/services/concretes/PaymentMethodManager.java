package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.repositories.PaymentMethodRepository;
import com.tobeto.rentACar.services.abstracts.PaymentMethodService;
import com.tobeto.rentACar.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.rentACar.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.rentACar.services.dtos.responses.paymentMethod.GetPaymentMethodListResponse;
import com.tobeto.rentACar.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PaymentMethodManager implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<GetPaymentMethodListResponse> getAll() {
        List<PaymentMethod> paymentMethodList = paymentMethodRepository.findAll();
        List<GetPaymentMethodListResponse> paymentMethodListResponses = new ArrayList<GetPaymentMethodListResponse>();
        for (PaymentMethod paymentMethod: paymentMethodList) {
            GetPaymentMethodListResponse paymentMethodResponse = new GetPaymentMethodListResponse();
            paymentMethodResponse.setId(paymentMethod.getId());
            paymentMethodResponse.setName(paymentMethod.getName());
            paymentMethodListResponses.add(paymentMethodResponse);
        }
        return paymentMethodListResponses;
    }

    @Override
    public GetPaymentMethodResponse getById(int id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow();
        GetPaymentMethodResponse dto = new GetPaymentMethodResponse();
        dto.setName(paymentMethod.getName());
        return dto;
    }

    @Override
    public void add(AddPaymentMethodRequest addPaymentMethodRequest) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(addPaymentMethodRequest.getName());
        paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void update(UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(updatePaymentMethodRequest.getId()).orElseThrow();
        paymentMethodToUpdate.setName(updatePaymentMethodRequest.getName());
        paymentMethodRepository.save(paymentMethodToUpdate);
    }

    @Override
    public void delete(int id) {
        paymentMethodRepository.deleteById(id);
    }

}
