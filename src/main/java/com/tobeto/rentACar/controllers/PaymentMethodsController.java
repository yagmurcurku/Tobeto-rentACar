package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.rentACar.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.rentACar.services.dtos.responses.paymentMethod.GetPaymentMethodListResponse;
import com.tobeto.rentACar.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;
import com.tobeto.rentACar.entities.PaymentMethod;
import com.tobeto.rentACar.repositories.PaymentMethodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/paymentmethods")
public class PaymentMethodsController {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodsController(PaymentMethodRepository paymentMethodRepository){
        this.paymentMethodRepository=paymentMethodRepository;
    }

    @GetMapping
    public List<GetPaymentMethodListResponse> getAll(){
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

    @GetMapping("{id}")
    public GetPaymentMethodResponse getById(@PathVariable int id){
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow();
        GetPaymentMethodResponse dto = new GetPaymentMethodResponse();
        dto.setName(paymentMethod.getName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentMethodRequest addPaymentMethodRequest){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName(addPaymentMethodRequest.getName());
        paymentMethodRepository.save(paymentMethod);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest){
        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(updatePaymentMethodRequest.getId()).orElseThrow();
        paymentMethodToUpdate.setName(updatePaymentMethodRequest.getName());
        paymentMethodRepository.save(paymentMethodToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentMethodRepository.deleteById(id);
    }

}
