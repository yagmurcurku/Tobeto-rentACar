package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.dtos.requests.role.AddRoleRequest;
import com.tobeto.rentACar.dtos.requests.role.UpdateRoleRequest;
import com.tobeto.rentACar.dtos.responses.role.GetRoleListResponse;
import com.tobeto.rentACar.dtos.responses.role.GetRoleResponse;
import com.tobeto.rentACar.entities.Role;
import com.tobeto.rentACar.repositories.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RolesController {

    private final RoleRepository roleRepository;

    public RolesController(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @GetMapping
    public List<GetRoleListResponse> getAll(){
        List<Role> roleList = roleRepository.findAll();
        List<GetRoleListResponse> roleListResponses = new ArrayList<GetRoleListResponse>();
        for (Role role: roleList) {
            GetRoleListResponse roleResponse = new GetRoleListResponse();
            roleResponse.setId(role.getId());
            roleResponse.setName(role.getName());
            roleListResponses.add(roleResponse);
        }
        return roleListResponses;
    }

    @GetMapping("{id}")
    public GetRoleResponse getById(@PathVariable int id){
        GetRoleResponse dto = new GetRoleResponse();
        Role role = roleRepository.findById(id).orElseThrow();
        dto.setName(role.getName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddRoleRequest addRoleRequest){
        Role role = new Role();
        role.setName(addRoleRequest.getName());
        roleRepository.save(role);
    }

    @PutMapping
    public void update(@RequestBody UpdateRoleRequest updateRoleRequest){
        Role roleToUpdate = roleRepository.findById(updateRoleRequest.getId()).orElseThrow();
        roleToUpdate.setName(updateRoleRequest.getName());
        roleRepository.save(roleToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        roleRepository.deleteById(id);
    }

}
