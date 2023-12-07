package com.tobeto.rentACar.services.dtos.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    @NotBlank(message = "isim alanı boş geçilemez !")
    @Size(min = 2, message = "isim minimum 2 karakterden oluşmalı !")
    private String firstName;

    @NotBlank(message = "soyisim alanı boş geçilemez")
    @Size(min = 3, message = "soyisim minimum 3 karakterden oluşmalı !")
    private String lastName;

    @Email
    private String email;

    @NotBlank(message = "Telefon alanı boş geçilemez !")
    @Size(min = 11, message = "Lütfen geçerli bir numara girin !")
    private String phone;

}
