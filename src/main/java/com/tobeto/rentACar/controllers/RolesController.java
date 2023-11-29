package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.services.abstracts.RoleService;
import com.tobeto.rentACar.services.dtos.requests.role.AddRoleRequest;
import com.tobeto.rentACar.services.dtos.requests.role.UpdateRoleRequest;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleListResponse;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleResponse;
import com.tobeto.rentACar.entities.Role;
import com.tobeto.rentACar.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/roles")
@AllArgsConstructor
public class RolesController {

    private final RoleService roleService;

    @GetMapping
    public List<GetRoleListResponse> getAll(){
        return roleService.getAll();
    }

    @GetMapping("{id}")
    public GetRoleResponse getById(@PathVariable int id){
        return roleService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddRoleRequest addRoleRequest){
        roleService.add(addRoleRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRoleRequest updateRoleRequest){
        roleService.update(updateRoleRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        roleService.delete(id);
    }

}
