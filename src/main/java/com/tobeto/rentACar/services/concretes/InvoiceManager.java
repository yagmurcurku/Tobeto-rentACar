package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.repositories.InvoiceRepository;
import com.tobeto.rentACar.services.abstracts.InvoiceService;
import com.tobeto.rentACar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.responses.car.GetByCarResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetByInvoiceResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceByDateResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceResponse;
import com.tobeto.rentACar.services.dtos.responses.rental.GetByRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public List<GetByInvoiceResponse> getByTotalPrice(double totalPrice) {
        List<Invoice> invoices = invoiceRepository.findByTotalPriceGreaterThanEqual(totalPrice);
        List<GetByInvoiceResponse> responses = new ArrayList<>();
        for (Invoice invoice: invoices) {
            GetByInvoiceResponse response = new GetByInvoiceResponse();
            response.setTotalPrice(invoice.getTotalPrice());
            response.setInvoiceDate(invoice.getInvoiceDate());
            response.setRental(new GetByRentalResponse(new GetByCarResponse(invoice.getRental().getCar().getPlate())));
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<GetByInvoiceResponse> getByInvoiceDate(LocalDate date) {
        List<Invoice> invoices = invoiceRepository.findByInvoiceDateLessThanEqual(date);
        List<GetByInvoiceResponse> responses = new ArrayList<>();
        for (Invoice invoice: invoices) {
            GetByInvoiceResponse response = new GetByInvoiceResponse();
            response.setInvoiceDate(invoice.getInvoiceDate());
            response.setTotalPrice(invoice.getTotalPrice());
            response.setRental(new GetByRentalResponse(new GetByCarResponse(invoice.getRental().getCar().getPlate())));
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<GetInvoiceByDateResponse> getInvoiceByDate(LocalDate startDate, LocalDate endDate) {
        return invoiceRepository.getInvoiceByDate(startDate, endDate);
    }

}
