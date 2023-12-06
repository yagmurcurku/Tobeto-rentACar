package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Role;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleByGenderResponse;
import com.tobeto.rentACar.services.dtos.responses.role.GetRoleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findByNameLike(String name);

    List<Role> findByNameNotLike(String name);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.role.GetRoleResponse(r.name) FROM Role r WHERE r.name=:name")
    List<GetRoleResponse> findAllRole(String name);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.role.GetRoleByGenderResponse(r.name," +
            "e.firstName, e.lastName) FROM Employee e INNER JOIN e.role r WHERE e.gender LIKE %:gender%")
    List<GetRoleByGenderResponse> findByGender(String gender);

}
