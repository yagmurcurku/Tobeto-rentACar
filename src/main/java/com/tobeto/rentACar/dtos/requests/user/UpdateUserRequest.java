package com.tobeto.rentACar.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
