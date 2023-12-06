package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.rentACar.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetByInvoiceResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceByDateResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceResponse;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {

    List<GetInvoiceListResponse> getAll();
    GetInvoiceResponse getById(int id);
    void add(AddInvoiceRequest addInvoiceRequest);
    void update(UpdateInvoiceRequest updateInvoiceRequest);
    void delete(int id);
    List<GetByInvoiceResponse> getByTotalPrice(double totalPrice);
    List<GetByInvoiceResponse> getByInvoiceDate(LocalDate date);
    List<GetInvoiceByDateResponse> getInvoiceByDate(LocalDate startDate, LocalDate endDate);

}
