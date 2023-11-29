package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import com.tobeto.rentACar.services.abstracts.InvoiceService;
import com.tobeto.rentACar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<GetInvoiceListResponse> getAll() {
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

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow();
        GetInvoiceResponse dto = new GetInvoiceResponse();
        dto.setTotalPrice(invoice.getTotalPrice());
        dto.setInvoiceDate(invoice.getInvoiceDate());
        dto.setRental(invoice.getRental());
        dto.setPaymentMethod(invoice.getPaymentMethod());
        dto.setEmployee(invoice.getEmployee());
        return dto;
    }

    @Override
    public void add(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice = new Invoice();
        invoice.setTotalPrice(addInvoiceRequest.getTotalPrice());
        invoice.setInvoiceDate(addInvoiceRequest.getInvoiceDate());
        //invoice.setRental(addInvoiceRequest.getRental());
        invoice.setPaymentMethod(addInvoiceRequest.getPaymentMethod());
        invoice.setEmployee(addInvoiceRequest.getEmployee());
        invoiceRepository.save(invoice);
    }

    @Override
    public void update(UpdateInvoiceRequest updateInvoiceRequest) {
        Invoice invoiceToUpdate = invoiceRepository.findById(updateInvoiceRequest.getId()).orElseThrow();
        invoiceToUpdate.setTotalPrice(updateInvoiceRequest.getTotalPrice());
        invoiceToUpdate.setInvoiceDate(updateInvoiceRequest.getInvoiceDate());
        //invoiceToUpdate.setRental(updateInvoiceRequest.getRental());
        invoiceToUpdate.setPaymentMethod(updateInvoiceRequest.getPaymentMethod());
        invoiceToUpdate.setEmployee(updateInvoiceRequest.getEmployee());
        invoiceRepository.save(invoiceToUpdate);
    }

    @Override
    public void delete(int id) {
        invoiceRepository.deleteById(id);
    }

}
