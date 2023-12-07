package com.tobeto.rentACar.services.dtos.requests.role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRoleRequest {

    @NotBlank(message = "Rol boş geçilemez !")
    @Size(min = 3, max = 35, message = "Girilen rolün uzunluğu 3 ile 35 karakter arasında olmalıdır !")
    private String name;

}
