package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
public class InvoicesController {

    private final InvoiceRepository invoiceRepository;

    public InvoicesController(InvoiceRepository invoiceRepository){
        this.invoiceRepository=invoiceRepository;
    }

    @GetMapping
    public List<Invoice> getAll(){
        return invoiceRepository.findAll();
    }

    @GetMapping("{id}")
    public Invoice getById(@PathVariable int id){
        return invoiceRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Invoice invoice){
        invoiceRepository.save(invoice);
    }

    @PutMapping
    public void update(@RequestBody Invoice invoice){
        Invoice invoiceToUpdate = invoiceRepository.findById(invoice.getId()).orElseThrow();
        invoiceToUpdate.setTotalPrice(invoice.getTotalPrice());
        invoiceToUpdate.setInvoiceDate(invoice.getInvoiceDate());
        invoiceToUpdate.setRental(invoice.getRental());
        invoiceToUpdate.setPaymentMethod(invoice.getPaymentMethod());
        invoiceToUpdate.setEmployee(invoice.getEmployee());
        invoiceRepository.save(invoiceToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        invoiceRepository.deleteById(id);
    }

}
