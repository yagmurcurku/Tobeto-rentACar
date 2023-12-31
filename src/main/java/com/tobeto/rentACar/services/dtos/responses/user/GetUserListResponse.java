package com.tobeto.rentACar.services.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
