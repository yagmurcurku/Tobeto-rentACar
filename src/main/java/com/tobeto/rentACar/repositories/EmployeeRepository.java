package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
