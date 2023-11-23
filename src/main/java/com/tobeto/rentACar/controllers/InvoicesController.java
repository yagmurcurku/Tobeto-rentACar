package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentACar.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentACar.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentACar.dtos.responses.invoice.GetInvoiceResponse;
import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/invoices")
public class InvoicesController {

    private final InvoiceRepository invoiceRepository;

    public InvoicesController(InvoiceRepository invoiceRepository){
        this.invoiceRepository=invoiceRepository;
    }

    @GetMapping
    public List<GetInvoiceListResponse> getAll(){
        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<GetInvoiceListResponse> invoiceListResponses = new ArrayList<GetInvoiceListResponse>();
        for (Invoice invoice: invoiceList) {
            GetInvoiceListResponse invoiceResponse = new GetInvoiceListResponse();
            invoiceResponse.setId(invoice.getId());
            invoiceResponse.setTotalPrice(invoice.getTotalPrice());
            invoiceResponse.setInvoiceDate(invoice.getInvoiceDate());
            invoiceResponse.setRental(invoice.getRental());
            invoiceResponse.setPaymentMethod(invoice.getPaymentMethod());
            invoiceResponse.setEmployee(invoice.getEmployee());
            invoiceListResponses.add(invoiceResponse);
        }
        return invoiceListResponses;
    }

    @GetMapping("{id}")
    public GetInvoiceResponse getById(@PathVariable int id){
        Invoice invoice = invoiceRepository.findById(id).orElseThrow();
        GetInvoiceResponse dto = new GetInvoiceResponse();
        dto.setTotalPrice(invoice.getTotalPrice());
        dto.setInvoiceDate(invoice.getInvoiceDate());
        dto.setRental(invoice.getRental());
        dto.setPaymentMethod(invoice.getPaymentMethod());
        dto.setEmployee(invoice.getEmployee());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddInvoiceRequest addInvoiceRequest){
        Invoice invoice = new Invoice();
        invoice.setTotalPrice(addInvoiceRequest.getTotalPrice());
        invoice.setInvoiceDate(addInvoiceRequest.getInvoiceDate());
        //invoice.setRental(addInvoiceRequest.getRental());
        invoice.setPaymentMethod(addInvoiceRequest.getPaymentMethod());
        invoice.setEmployee(addInvoiceRequest.getEmployee());
        invoiceRepository.save(invoice);
    }

    @PutMapping
    public void update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest){
        Invoice invoiceToUpdate = invoiceRepository.findById(updateInvoiceRequest.getId()).orElseThrow();
        invoiceToUpdate.setTotalPrice(updateInvoiceRequest.getTotalPrice());
        invoiceToUpdate.setInvoiceDate(updateInvoiceRequest.getInvoiceDate());
        //invoiceToUpdate.setRental(updateInvoiceRequest.getRental());
        invoiceToUpdate.setPaymentMethod(updateInvoiceRequest.getPaymentMethod());
        invoiceToUpdate.setEmployee(updateInvoiceRequest.getEmployee());
        invoiceRepository.save(invoiceToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        invoiceRepository.deleteById(id);
    }

}
