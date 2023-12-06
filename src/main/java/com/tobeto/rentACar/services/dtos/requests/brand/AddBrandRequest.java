package com.tobeto.rentACar.services.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {

    @NotBlank(message = "Marka adı boş geçilemez !")
    //@Length(min = 3, max = 20)
    @Size(min = 3, max = 20, message = "Marka adının uzunluğu 3 ile 20 arasında olmalıdır.")
    private String name;

}
