package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.InvoiceService;
import com.tobeto.rentACar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetByInvoiceResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceByDateResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceResponse;
import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/getByTotalPrice")
    public List<GetByInvoiceResponse> getByTotalPrice(@RequestParam double totalPrice){
        return invoiceService.getByTotalPrice(totalPrice);
    }

    @GetMapping("/getByInvoiceYear")
    public List<GetByInvoiceResponse> getByInvoiceYear(@RequestParam LocalDate date){
        return invoiceService.getByInvoiceDate(date);
    }

    @GetMapping("/getInvoiceByDate")
    public List<GetInvoiceByDateResponse> getByDate(@RequestParam LocalDate startDate, LocalDate endDate){
        return invoiceService.getInvoiceByDate(startDate, endDate);
    }

    @GetMapping("/getByDateAndGender")
    public List<GetInvoiceByDateResponse> getByInvoiceAndDate(@RequestParam LocalDate date, String gender){
        return invoiceService.getInvoiceByDateAndGender(date, gender);
    }


}
