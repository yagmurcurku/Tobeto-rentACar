package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.InvoiceService;
import com.tobeto.rentACar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceResponse;
import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/invoices")
@AllArgsConstructor
public class InvoicesController {

    private final InvoiceService invoiceService;

    @GetMapping
    public List<GetInvoiceListResponse> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("{id}")
    public GetInvoiceResponse getById(@PathVariable int id){
        return invoiceService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddInvoiceRequest addInvoiceRequest){
        invoiceService.add(addInvoiceRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest){
        invoiceService.update(updateInvoiceRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        invoiceService.delete(id);
    }

}
