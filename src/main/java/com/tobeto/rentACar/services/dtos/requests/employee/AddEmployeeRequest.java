package com.tobeto.rentACar.services.dtos.requests.employee;

import com.tobeto.rentACar.entities.Location;
import com.tobeto.rentACar.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private String gender;
    private String identificationNumber;
    private Location location;
    private Role role;

}
