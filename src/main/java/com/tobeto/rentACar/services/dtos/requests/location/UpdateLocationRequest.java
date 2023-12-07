package com.tobeto.rentACar.services.dtos.requests.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationRequest {

    @NotNull            //int veri tiplerine @NotBlank uygulanmaz. --> @NotNull uygulandı.
    private int id;

    @NotBlank(message = "Lütfen şehir girin")
    @Size(min = 3, max = 20, message = "Şehir adının uzunluğu 3 ile 20 arasında olmalı")
    private String city;

    @NotBlank(message = "şube ofis adı girin")
    @Size(min = 4, max = 25, message = "şube ofis adı minimum 4 karakterden oluşmalı")
    private String branchOffice;

    @NotNull
    @Size(min = 11, message = "Lütfen geçerli bir telefon numarası girin.")
    private String officePhone;



}
