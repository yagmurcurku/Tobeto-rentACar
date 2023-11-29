package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.requests.role.AddRoleRequest;
import com.tobeto.rentACar.services.dtos.requests.role.UpdateRoleRequest;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleListResponse;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleResponse;

import java.util.List;

public interface RoleService {

    List<GetRoleListResponse> getAll();
    GetRoleResponse getById(int id);
    void add(AddRoleRequest addRoleRequest);
    void update(UpdateRoleRequest updateRoleRequest);
    void delete(int id);

}
