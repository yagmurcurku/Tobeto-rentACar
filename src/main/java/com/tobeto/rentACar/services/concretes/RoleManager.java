package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Role;
import com.tobeto.rentACar.repositories.RoleRepository;
import com.tobeto.rentACar.services.abstracts.RoleService;
import com.tobeto.rentACar.services.dtos.requests.role.AddRoleRequest;
import com.tobeto.rentACar.services.dtos.requests.role.UpdateRoleRequest;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleListResponse;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<GetRoleListResponse> getAll() {
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

    @Override
    public GetRoleResponse getById(int id) {
        GetRoleResponse dto = new GetRoleResponse();
        Role role = roleRepository.findById(id).orElseThrow();
        dto.setName(role.getName());
        return dto;
    }

    @Override
    public void add(AddRoleRequest addRoleRequest) {
        Role role = new Role();
        role.setName(addRoleRequest.getName());
        roleRepository.save(role);
    }

    @Override
    public void update(UpdateRoleRequest updateRoleRequest) {
        Role roleToUpdate = roleRepository.findById(updateRoleRequest.getId()).orElseThrow();
        roleToUpdate.setName(updateRoleRequest.getName());
        roleRepository.save(roleToUpdate);
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

}
